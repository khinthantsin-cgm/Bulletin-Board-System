package ojt.bulletin.bl.service;

import java.io.IOException;
import java.util.List;

import ojt.bulletin.bl.dto.UserDto;
import ojt.bulletin.web.form.UserForm;

public interface UserService {

    public void doCreateUser(UserForm userForm, int currentUserId) throws IOException;

    public List<UserDto> doGetUserList();

    public UserForm doGetUserById(int userId);

    public void doDeleteUser(int userId, int deletedUserId);

    public UserDto doFindByEmail(String email);

    public void doUpdateUser(UserForm userForm, int loginUserId) throws IOException;

}
