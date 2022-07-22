package ojt.bulletin.persistence.dao;

import java.util.Date;
import java.util.List;

import ojt.bulletin.persistence.entity.Post;

public interface PostDao {
    public List<Post> dbGetPostList();

    public void dbCreatePost(Post post, int createdUserID, Date currentDate);

    public void dbDeletePost(Integer postId);

    public Post dbGetPostById(int postId);

    void dbUpdatePost(Post post);

    Post dbGetPostbyTitle(String title);
}
