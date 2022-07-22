package ojt.bulletin.bl.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ojt.bulletin.bl.dto.UserDto;
import ojt.bulletin.bl.service.LoginService;
import ojt.bulletin.bl.service.UserService;
import ojt.bulletin.persistence.dao.UserDao;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDao userDao;
	@Autowired
    UserService userService;
	@Autowired
	@Qualifier("myUserDetailsService")
	private UserDetailsService userDetailsService;
	@Override
	public UserDto doGetLoggedInResult() {
		String email = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		return userService.doFindByEmail(email);
		/*User user = this.userDao.dbGetUserByEmail(email);
		UserDto userDto = new UserDto(user);
		return userDto;*/
	}
	@Override
	public boolean doIsLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
		        && authentication.isAuthenticated();
	}
	@Override
	public void doLoadAuth(String email) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(email);
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
				userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	public void doLogout(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        request.getSession(true).invalidate();
    }
}
