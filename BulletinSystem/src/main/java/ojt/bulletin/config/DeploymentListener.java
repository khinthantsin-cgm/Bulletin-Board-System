package ojt.bulletin.config;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.bulletin.persistence.dao.UserDao;
import ojt.bulletin.persistence.entity.User;
import ojt.bulletin.web.form.UserForm;


@Component
public class DeploymentListener {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void addInitialData() {
		if (this.userDao.dbGetUserCount() <= 0) {
			// Admin
			UserForm userAdminForm = new UserForm();
			userAdminForm.setName("ADMIN");
			userAdminForm.setEmail("admin@gmail.com");
			userAdminForm.setPassword(passwordEncoder.encode("111111"));
			userAdminForm.setType("1");
			userAdminForm.setPhone("09781111111");
			userAdminForm.setAddress("Yangon, Myanmar");
			userAdminForm.setCreatedAt(new Date());
			User userAdmin = new User(userAdminForm);
			this.userDao.dbCreateUser(userAdmin, 1, new Date());

			

			// User
			UserForm userForm = new UserForm();
			userForm.setName("USER");
			userForm.setEmail("user@gmail.com");
			userForm.setPassword(passwordEncoder.encode("111111"));
			userForm.setType("2");
			userForm.setPhone("09781111111");
			userForm.setAddress("Yangon, Myanmar");
			userForm.setCreatedAt(new Date());
			User user = new User(userForm);
			this.userDao.dbCreateUser(user, 1, new Date());
		}
	}
}