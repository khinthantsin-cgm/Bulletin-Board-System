package ojt.bulletin.bl.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ojt.bulletin.bl.dto.PostDto;
import ojt.bulletin.web.form.PostForm;

public interface PostService {

    public List<PostDto> doGetPostList() throws FileNotFoundException, IOException;

    public PostForm doGetPostById(int postId) throws FileNotFoundException, IOException;

    public void doDeletePost(Integer postId);

    public boolean isTitleExist(String title);

    public void doCreatePost(PostForm postForm, int createdUserID, String postImagePath) throws FileNotFoundException, IOException;

    public void doUpdatePost(PostForm postForm, String postImagePath) throws FileNotFoundException, IOException;
}
