package ojt.bulletin.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.bulletin.bl.dto.UserDto;
import ojt.bulletin.bl.service.LoginService;
import ojt.bulletin.bl.service.UserService;
import ojt.bulletin.persistence.entity.User;
import ojt.bulletin.web.form.UserForm;

@Controller
public class UserController {
    @Autowired
    private HttpSession session;

    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2>encoder</h2>
     * <p>
     * encoder
     * </p>
     */

    @Autowired
    private LoginService loginService;

    /*
     * @RequestMapping(value = "/showLogin", params = "login", method =
     * RequestMethod.POST) public ModelAndView
     * showUserLogin(@ModelAttribute("userForm") @Valid UserForm userForm,
     * BindingResult result, HttpSession session, HttpServletRequest request,
     * HttpServletResponse response) throws Exception { ModelAndView userCView = new
     * ModelAndView("login"); if (result.hasErrors()) { return userCView; } UserDto
     * loginUser = this.loginService.doGetLoggedInResult(); if (loginUser != null &&
     * (loginUser.getPassword() != null && loginUser.getEmail() != null)) {
     * session.setAttribute("LOGIN_USER", loginUser);
     * session.setAttribute("loginUserId", loginUser.getId()); userCView = new
     * ModelAndView("redirect:/userList"); } else { userCView = new
     * ModelAndView("login"); userCView.addObject("errorMsg",
     * messageSource.getMessage("M_SC_0001", null, null)); } return userCView; }
     */

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public ModelAndView viewLogin(ModelAndView model) {
        // UserDto loginUser = this.loginService.doGetLoggedInResult();
        if (loginService.doIsLoggedIn()) {
            if (loginService.doGetLoggedInResult().getType() == "1") {
                return new ModelAndView("redirect:/userList");
            }
            System.out.print(loginService.doGetLoggedInResult().getName());
            return new ModelAndView("redirect:/userList");
        }
        ModelAndView mv = new ModelAndView("userLogin");
        return mv;
    }

    /**
     * <h2>login</h2>
     * <p>
     * 
     * </p>
     *
     * @param error
     * @param model
     * @param request
     * @return
     * @return String
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, ModelMap model,
            HttpServletRequest request) {
        // UserDto loginUser = this.loginService.doGetLoggedInResult();
        if (loginService.doIsLoggedIn()) {
            /*
             * if (loginService.doGetLoggedInResult().getType() == "1") { return "userList";
             * } System.out.print(loginService.doGetLoggedInResult().getType());
             */
            return "userList";
        }
        /*
         * if (error != null) { model.addAttribute("errorMsg", getErrorMessage(request,
         * "SPRING_SECURITY_LAST_EXCEPTION")); }
         */
        return "userLogin";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView getUserList(ModelAndView model) throws IOException {
        List<UserDto> UserList = userService.doGetUserList();
        model.addObject("UserList", UserList);
        model.setViewName("userList");
        session.setAttribute("LOGIN_USER", loginService.doGetLoggedInResult());
        session.setAttribute("loginUserId", loginService.doGetLoggedInResult().getId());
        return model;
    }

    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public ModelAndView userDetail(@RequestParam("id") Integer userId, HttpServletRequest request) {
        ModelAndView userView = new ModelAndView("userDetail");
        UserForm userDetail = null;
        try {
            userDetail = this.userService.doGetUserById(userId);
        } catch (NullPointerException e) {
            userView = new ModelAndView("redirect:/userList");
        }

        userView.addObject("userDetail", userDetail);
        return userView;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    /*
     * public ModelAndView createUser(Model model) { User user = new User(); boolean
     * isLoggedIn = loginService.doIsLoggedIn(); ModelAndView mv = new
     * ModelAndView("createUser"); mv.addObject("rollBackUserForm", user); if
     * (isLoggedIn) { mv.addObject("LOGIN_USER",
     * loginService.doGetLoggedInResult()); } return mv;
     * 
     * 
     * /* public ModelAndView createUser(ModelAndView model) { User user = new
     * User(); ModelAndView createUser = new ModelAndView("createUser");
     * createUser.addObject("rollBackUserForm", user);
     * createUser.setViewName("createUser"); if (loginService.doIsLoggedIn()) {
     * createUser.addObject("LOGIN_USER", loginService.doGetLoggedInResult()); }
     * return createUser;
     */

    public ModelAndView createUser(ModelAndView model) {
        User user = new User();
        ModelAndView createUser = new ModelAndView("createUser");
        createUser.addObject("rollBackUserForm", user);
        createUser.setViewName("createUser");
        return createUser;
    }

    /**
     * <h2>createUserConfirm</h2>
     * <p>
     * Method for showing Confirm view of user creation
     * </p>
     *
     * @param userForm  UserForm
     * @param result    BindingResult
     * @param session   HttpSession
     * @param request   HttpServletRequest
     * @param imageData String
     * @return
     * @throws ParseException
     * @return ModelAndView
     */
    @RequestMapping(value = "/createUserConfirm", params = "confirmUser", method = RequestMethod.POST)
    public ModelAndView createUserConfirm(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result,
            HttpSession session, HttpServletRequest request)
            throws ParseException {
        ModelAndView userConfirmView = new ModelAndView("createUserConfirm");
        if (result.hasErrors()) {
            userConfirmView.addObject("userForm", userForm);
            userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return userConfirmView;
        }
        if (!userForm.getPassword().equals(request.getParameter("confirmPassword"))) {
            userConfirmView.addObject("userForm", userForm);
            userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0009", null, null));
            return userConfirmView;
        }
        /*
         * if (userService.isUserExist(userForm.getEmail())) {
         * userConfirmView.addObject("rollBackUserForm", userForm);
         * userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0010",
         * null, null)); return userConfirmView; }
         */
        // userConfirmView = new ModelAndView("createUserConfirm");

        userConfirmView.addObject("userForm", userForm);
        return userConfirmView;
    }

    /**
     * <h2>insertUser</h2>
     * <p>
     * Method of Do Create and show in list
     * </p>
     *
     * @param userForm UserForm
     * @param result   BindingResult
     * @param request  HttpServletRequest
     * @return
     * @throws ParseException
     * @return ModelAndView
     * @throws IOException
     */

    @RequestMapping(value = "/insertUser", params = "addUser", method = RequestMethod.POST)
    public ModelAndView insertUser(@ModelAttribute("createUser") @Valid UserForm userForm, BindingResult result,
            HttpServletRequest request) throws ParseException, IOException {
        session.setAttribute("LOGIN_USER", loginService.doGetLoggedInResult());
        session.setAttribute("loginUserId", loginService.doGetLoggedInResult().getId() );
        int loginUserId = (int) request.getSession().getAttribute("loginUserId");
        //System.out.print(loginUserId);
        this.userService.doCreateUser(userForm, loginUserId);
        ModelAndView createUserView = new ModelAndView("redirect:/userList");
        return createUserView;
    }

    /**
     * <h2>calcelUserCreate</h2>
     * <p>
     * Method to call if user cancel creation
     * </p>
     *
     * @param userForm UserFormv
     * @param result   BindingResult
     * @param session  HttpSession
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/insertUser", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelUserCreate(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result,
            HttpSession session) {
        ModelAndView createUserView = new ModelAndView("createUser");
        createUserView.addObject("rollBackUserForm", userForm);
        return createUserView;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") Integer userId, HttpServletRequest request) {
        int loginUserId = (int) request.getSession().getAttribute("loginUserId");
        ModelAndView updateView = new ModelAndView();
        this.userService.doDeleteUser(userId, loginUserId);
        // this.getPagination(updateView, 1, 10, false, new SearchUserDto());
        updateView.setViewName("redirect:/userList");
        session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0013", null, null));
        return updateView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("LOGIN_USER");
        loginService.doLogout(request);
        return "redirect:/userLogin";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public ModelAndView updateUser(@RequestParam("id") Integer userID, HttpServletRequest request) {
        ModelAndView updateView = new ModelAndView("updateUser");
        UserForm updateUser = null;
        try {
            updateUser = this.userService.doGetUserById(userID);
        } catch (NullPointerException e) {
            updateView = new ModelAndView("redirect:/error500");
        }

        updateView.addObject("oldUserForm", updateUser);
        return updateView;
    }

    /**
     * <h2>confirmUserUpdate</h2>
     * <p>
     * Method to call user Confirm View
     * </p>
     *
     * @param updateUserForm UserForm
     * @param result         BindingResult
     * @param request        HttpServletRequest
     * @param session        HttpSession
     * @param imageData      String
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateUserConfirm", method = RequestMethod.POST)
    public ModelAndView confirmUserUpdate(@ModelAttribute("oldUserForm") @Valid UserForm updateUserForm,
            HttpServletRequest request, BindingResult result, HttpSession session) throws IOException {
        ModelAndView updateConfirmView = new ModelAndView("updateUser");
        if (result.hasErrors()) {
            updateConfirmView.addObject("updateUserForm", updateUserForm);
            updateConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0008", null, null));
            return updateConfirmView;
        }
        /*
         * if (this.userService.isUpdateEmailExist(updateUserForm.getEmail(),
         * updateUserForm.getId())) { updateConfirmView.addObject("updateUserForm",
         * updateUserForm); updateConfirmView.addObject("errorMsg",
         * messageSource.getMessage("M_SC_0010", null, null)); return updateConfirmView;
         * }
         */
        // UserForm userById = this.userService.doGetUserById(updateUserForm.getId());
        updateConfirmView = new ModelAndView("updateUserConfirm");

        updateConfirmView.addObject("updateUserForm", updateUserForm);
        return updateConfirmView;
    }

    /**
     * <h2>updateUser</h2>
     * <p>
     * To do update user and show on list
     * </p>
     *
     * @param userForm
     * @param result
     * @param session
     * @param request
     * @return
     * @throws ParseException
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/editUser", params = "update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("updateUserForm") @Valid UserForm userForm, BindingResult result,
            HttpSession session, HttpServletRequest request) throws ParseException, IOException {
        int loginUserId = (int) request.getSession().getAttribute("loginUserId");

        this.userService.doUpdateUser(userForm, loginUserId);
        ModelAndView updateUserView = new ModelAndView("redirect:/userDetail?id=" + userForm.getId());
        return updateUserView;
    }

    /**
     * <h2>cancelUpdateUser</h2>
     * <p>
     * method to cancel updating user
     * </p>
     *
     * @param userForm
     * @param result
     * @param session
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/editUser", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelUpdateUser(@ModelAttribute("updateUserForm") @Valid UserForm userForm,
            BindingResult result, HttpSession session) {
        ModelAndView updateUserView = new ModelAndView("updateUser");
        updateUserView.addObject("oldUserForm", userForm);
        return updateUserView;
    }

    /**
     * <h2>denied</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public ModelAndView denied() {
        ModelAndView createView = new ModelAndView("accessDenied");
        return createView;
    }
}
