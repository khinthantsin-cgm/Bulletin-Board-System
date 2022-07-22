package ojt.bulletin.bl.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ojt.bulletin.bl.dto.UserDto;
import ojt.bulletin.bl.service.UserService;
import ojt.bulletin.persistence.dao.UserDao;
import ojt.bulletin.persistence.entity.User;
import ojt.bulletin.web.form.UserForm;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDto> doGetUserList() {
        List<User> userForm = (List<User>) this.userDao.dbGetUserList();
        List<UserDto> listUserDTO = new ArrayList<>();
        for (User user : userForm) {
            UserDto entity2Dto = new UserDto(user);
            listUserDTO.add(entity2Dto);
        }
        return listUserDTO;
    }

    @Override
    public void doCreateUser(UserForm userForm, int currentUserId) throws IOException {

        /*
         * String pw = userForm.getPassword(); String pwEncode = encoder.encode(pw);
         * userForm.setPassword(pwEncode);
         */
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        User user = new User(userForm);

        userDao.dbCreateUser(user, currentUserId, new Date());
    }

    @Override
    @Transactional
    public UserForm doGetUserById(int userId) {
        User resultUser = this.userDao.dbGetUserById(userId);
        UserForm resultUserform = resultUser != null ? new UserForm(resultUser) : null;

        return resultUserform;
    }

    @Override
    public void doDeleteUser(int userId, int deletedUserId) {
        User deletedUser = this.userDao.dbGetUserById(userId);
        deletedUser.setDeletedAt(new Date());
        deletedUser.setDeletedUserId(deletedUserId);
    }

    @Override
    public UserDto doFindByEmail(String email) {
        UserDto userDto = new UserDto(userDao.dbGetUserByEmail(email));
        return userDto;
    }

    @Override
    public void doUpdateUser(UserForm userForm, int currentUserId) throws IOException {
        User user = new User(userForm);
        Date currentDate = new Date();

        User updatedUser = this.userDao.dbGetUserById(userForm.getId());
        if (updatedUser != null) {
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setType(user.getType());
            updatedUser.setDob(user.getDob());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setAddress(user.getAddress());
        }
        this.userDao.dbUpdateUser(updatedUser, currentUserId, currentDate);
    }

}
