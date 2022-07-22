package ojt.bulletin.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ojt.bulletin.bl.service.LoginService;

@SuppressWarnings("deprecation")
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	LoginService loginService;
	

    /**
     * <h2>preHandle</h2>
     * <p>
     * 
     * </p>
     * 
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!loginService.doIsLoggedIn()) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else if (loginService.doGetLoggedInResult().getType() == "1") {
            System.out.println(loginService.doGetLoggedInResult().getType());
            response.sendRedirect(request.getContextPath() + "/denied");
        }
        return true;
    }
}
