package ojt.bulletin.persistence.dao;

import java.util.Date;
import java.util.List;

import ojt.bulletin.persistence.entity.User;

public interface UserDao {
	  public void dbCreateUser(User user, int createUserId, Date currentDate);

	public List<User> dbGetUserList();

	public User dbGetUserById(int userId);

	public User dbGetUserByEmail(String email);

	public long dbGetUserCount();

    public void dbUpdateUser(User user, int updateUserId, Date currentDate);

//	public User dbFindByEmail(String email);
}
