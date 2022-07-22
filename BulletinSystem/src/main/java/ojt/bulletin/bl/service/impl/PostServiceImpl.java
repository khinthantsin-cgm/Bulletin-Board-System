package ojt.bulletin.bl.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.bulletin.bl.dto.PostDto;
import ojt.bulletin.bl.service.PostService;
import ojt.bulletin.persistence.dao.PostDao;
import ojt.bulletin.persistence.entity.Post;
import ojt.bulletin.web.form.PostForm;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<PostDto> doGetPostList() throws IOException {
        List<Post> postForm = (List<Post>) this.postDao.dbGetPostList();
        List<PostDto> listPostDTO = new ArrayList<>();
        for (Post post : postForm) {
            PostDto entity2Dto = new PostDto(post);
            
            if (entity2Dto.getImage() != null) {
                String postImagePath = entity2Dto.getImage();
                File postImage = new File(postImagePath);
                entity2Dto.setImage(null);
                if (postImage.exists()) {
                    FileInputStream fis = new FileInputStream(postImage);
                    byte byteArray[] = new byte[(int)postImage.length()];
                    fis.read(byteArray);
                    String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                    entity2Dto.setImage(imageString);

                }
            }
            listPostDTO.add(entity2Dto);
        }
        return listPostDTO;
    }

    @Override
    public void doCreatePost(PostForm postForm, int createdUserID,String postImagePath) throws FileNotFoundException, IOException {
        String imageBase64 = postForm.getImage();
        if (!imageBase64.isEmpty() && !imageBase64.equals("") && !imageBase64.equals(null)) {
            String[] block = imageBase64.split(",");
            String realData = block[1];
            byte[] data = Base64.decodeBase64(realData);
            try (FileOutputStream stream = new FileOutputStream(postImagePath)) {
                stream.write(data);
            }
            postForm.setImage(postImagePath);
        }
        Post post = new Post(postForm);
        this.postDao.dbCreatePost(post, createdUserID, new Date());
    }

    @Override
    @Transactional
    public PostForm doGetPostById(int postId) throws IOException {
        Post resultPost = this.postDao.dbGetPostById(postId);
        PostForm resultPostform = resultPost != null ? new PostForm(resultPost) : null;
        if (resultPostform.getImage() != null) {
            String medicineImagePath = resultPostform.getImage();
            File medicineImage = new File(medicineImagePath);
            resultPostform.setImage(null);
            if (medicineImage.exists()) {
                FileInputStream fis = new FileInputStream(medicineImage);
                byte byteArray[] = new byte[(int) medicineImage.length()];
                fis.read(byteArray);
                String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                resultPostform.setImage(imageString);
            }
        }
        return resultPostform;
    }

    @Override
    @Transactional
    public void doDeletePost(Integer postId) {
        postDao.dbDeletePost(postId);
    }

    @Override
    public void doUpdatePost(PostForm postForm,String postImagePath) throws FileNotFoundException, IOException {
        Post post = new Post(postForm);
        Date currentDate = new Date();
        Post updatePost = this.postDao.dbGetPostById(post.getId());
        Post postByTitle = this.postDao.dbGetPostbyTitle(post.getTitle());
        String updateImagePath = postForm.getImage();
        if (postImagePath.length() > 0) {
            if (updateImagePath.length() > 0 && !updateImagePath.equals(postImagePath)) {
                System.out.println(postImagePath);
                File deletedOldImage = new File(postImagePath);
                deletedOldImage.delete();
                String imageBase64 = postForm.getImage();
                String[] block = imageBase64.split(",");
                String realData = block[1];
                byte[] data = Base64.decodeBase64(realData);
                try (FileOutputStream stream = new FileOutputStream(postImagePath)) {
                    stream.write(data);
                }
            }
        } else {
            postImagePath = updateImagePath;
        }
        post.setImage(postImagePath);
        if (updatePost != null) {
            if (postByTitle == null || (postByTitle != null && postByTitle.getTitle() == updatePost.getTitle())) {
                updatePost.setTitle(post.getTitle());
                updatePost.setDescription(post.getDescription());
                updatePost.setImage(post.getImage());
                updatePost.setUpdatedAt(currentDate);

            }
            this.postDao.dbUpdatePost(updatePost);
        }
    }

    @Override
    public boolean isTitleExist(String title) {
        Post resultPost = this.postDao.dbGetPostbyTitle(title);
        boolean titleExist = false;
        if (resultPost != null) {
            titleExist = true;
        }
        return titleExist;
    }

  
}