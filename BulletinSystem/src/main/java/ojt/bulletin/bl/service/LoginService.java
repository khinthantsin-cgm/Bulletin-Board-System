package ojt.bulletin.bl.service;

import javax.servlet.http.HttpServletRequest;

import ojt.bulletin.bl.dto.UserDto;

public interface LoginService {
public UserDto doGetLoggedInResult();

public boolean doIsLoggedIn();

public void doLoadAuth(String email);

public void doLogout(HttpServletRequest request);
}
