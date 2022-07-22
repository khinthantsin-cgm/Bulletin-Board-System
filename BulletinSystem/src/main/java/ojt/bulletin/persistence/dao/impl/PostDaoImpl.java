package ojt.bulletin.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.bulletin.persistence.dao.PostDao;
import ojt.bulletin.persistence.dao.UserDao;
import ojt.bulletin.persistence.entity.Post;
import ojt.bulletin.persistence.entity.User;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    public static String SELECT_POST_BY_TITLE_HQL = "FROM Post p " + "WHERE p.title = :title ";

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<Post> dbGetPostList() {
        @SuppressWarnings("rawtypes")
        Query query = sessionFactory.getCurrentSession().createQuery("Select p From Post p Where p.deletedAt IS NULL");
        return query.getResultList();
    }

    @Override
    public void dbCreatePost(Post post, int createdUserID, Date currentDate) {

        post.setCreatedUserID(createdUserID);
        post.setCreatedAt(currentDate);

        User name = userDao.dbGetUserById(createdUserID);
        post.setCreatedUserName(name.getName());
        this.sessionFactory.getCurrentSession().save(post);
    }

    @Override
    public void dbDeletePost(Integer postId) {
        Post post = (Post) sessionFactory.getCurrentSession().load(Post.class, postId);
        if (null != post) {
            post.setDeletedAt(new Date());
            this.sessionFactory.getCurrentSession().update(post);
        }
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public Post dbGetPostById(int postId) {
        Query queryPostById = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM Post p where p.id = :id");
        queryPostById.setParameter("id", postId);
        Post resultPost = (Post) queryPostById.uniqueResult();
        return resultPost;
    }

    @Override
    public void dbUpdatePost(Post post) {
        this.sessionFactory.getCurrentSession().update(post);
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public Post dbGetPostbyTitle(String title) {
        Query queryPostByTitle = this.sessionFactory.getCurrentSession().createQuery(SELECT_POST_BY_TITLE_HQL);
        queryPostByTitle.setParameter("title", title);
        Post resultPost = (Post) queryPostByTitle.uniqueResult();
        return resultPost;
    }
}
