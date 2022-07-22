package ojt.bulletin.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.bulletin.persistence.dao.UserDao;
import ojt.bulletin.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<User> dbGetUserList() {
        @SuppressWarnings("rawtypes")
        Query query = sessionFactory.getCurrentSession().createQuery("Select u From User u Where u.deletedAt IS NULL");
        return query.getResultList();
    }

    @Override
    public void dbCreateUser(User user, int createUserId, Date currentDate) {
        user.setCreatedUserId(createUserId);
        user.setCreatedAt(currentDate);
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public User dbGetUserById(int userId) {
        Query queryUserById = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM User p where p.id = :id");
        queryUserById.setParameter("id", userId);
        User resultUser = (User) queryUserById.uniqueResult();
        return resultUser;

    }

    @Override
    public void dbUpdateUser(User user, int updateUserId, Date currentDate) {
        user.setUpdatedUserId(updateUserId);
        user.setUpdatedAt(currentDate);
        this.sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public User dbGetUserByEmail(String email) {
        Query<User> queryUserByEmail = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u where u.email = :email");
        queryUserByEmail.setParameter("email", email);
        User user = queryUserByEmail.uniqueResult();
        return user;
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }

    /*
     * @SuppressWarnings({ "rawtypes", "deprecation" })
     * 
     * @Override public User dbFindByEmail(String email) { String userHqlQuery =
     * "SELECT u FROM User u where u.email = :email"; Query queryUserById =
     * this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
     * queryUserById.setParameter("email", email); User resultUser = (User)
     * queryUserById.uniqueResult(); return resultUser; }
     */
}
