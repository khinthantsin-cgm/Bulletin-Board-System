package ojt.bulletin.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.bulletin.bl.dto.PostDto;
import ojt.bulletin.bl.service.PostService;
import ojt.bulletin.persistence.entity.Post;
import ojt.bulletin.web.form.PostForm;

@Controller
public class PostController {
    @Autowired
    MessageSource messageSource;

    @Autowired
    PostService postService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    public ModelAndView getPostList(ModelAndView model) throws IOException {
        List<PostDto> PostList = postService.doGetPostList();
        model.addObject("PostList", PostList);
        model.setViewName("postList");
        return model;

    }

    @RequestMapping(value = "/postDetail", method = RequestMethod.GET)
    public ModelAndView postDetail(@RequestParam("id") Integer postId, HttpServletRequest request) throws FileNotFoundException, IOException {
        ModelAndView postView = new ModelAndView("postDetail");
        PostForm postDetail = null;
        try {
            postDetail = this.postService.doGetPostById(postId);
        } catch (NullPointerException e) {
            postView = new ModelAndView("redirect:/postList");
        }

        postView.addObject("postDetail", postDetail);
        return postView;
    }

    /**
     * <h2>newPost</h2>
     * <p>
     * showing post form
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/createPost", method = RequestMethod.GET)
    public ModelAndView newPost(ModelAndView model) {
        Post post = new Post();
        ModelAndView createPost = new ModelAndView("createPost");
        createPost.addObject("createPostForm", post);
        createPost.setViewName("createPost");
        return createPost;
    }

    /**
     * <h2>insertPost</h2>
     * <p>
     * confirmimg new added post
     * </p>
     *
     * @param postForm
     * @param result
     * @param request
     * @return
     * @throws ParseException
     * @return ModelAndView
     */
    @RequestMapping(value = "/createPostConfirm", params = "confirmPost", method = RequestMethod.POST)
    public ModelAndView insertPost(@ModelAttribute("postForm") @Valid PostForm postForm, BindingResult result,
            HttpServletRequest request,@RequestParam("imageData") String imageData) throws ParseException {
        ModelAndView ConfirmView = new ModelAndView("createPostConfirm");
        // int loginUserId = (int) request.getSession().getAttribute("loginUserId");
        // System.out.print(loginUserId);
        if (result.hasErrors()) {
            ConfirmView = new ModelAndView("createPost");
            ConfirmView.addObject("postForm", postForm);
            ConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0001", null, null));
        } else if (this.postService.isTitleExist(postForm.getTitle())) {
            ConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0003", null, null));
            return ConfirmView;
        } else {
            ConfirmView.addObject("postForm", postForm);
            ConfirmView.setViewName("createPostConfirm");
        }
        if (imageData.length() > 0) {
            postForm.setImage(imageData);
        }
        return ConfirmView;
    }

    /**
     * <h2>createPostConfirm</h2>
     * <p>
     * Inserting new post
     * </p>
     *
     * @param postForm
     * @param result
     * @param request
     * @param response
     * @return
     * @return ModelAndView
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("deprecation")
    @RequestMapping(value = "/insertPost", params = "addPost", method = RequestMethod.POST)
    public ModelAndView createPostConfirm(@ModelAttribute("postForm") @Valid PostForm postForm, BindingResult result,
            HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        int loginUserId = (int) request.getSession().getAttribute("loginUserId");
        String postImagePath = request.getRealPath("/") + "/resources/images/" + postForm.getTitle();
        Path uploadPath = Paths.get(postImagePath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        postImagePath= uploadPath + "/" + postForm.getTitle() + ".png";
        System.out.println(postImagePath);
        this.postService.doCreatePost(postForm, loginUserId,postImagePath);
        ModelAndView createPostView = new ModelAndView("redirect:/postList");
        session.setAttribute("completeMsg", messageSource.getMessage("M_SC_0005", null, null));
        return createPostView;

    }

    /**
     * <h2>cancelPostConfirm</h2>
     * <p>
     * Canceling inserted post in form
     * </p>
     *
     * @param postForm
     * @param result
     * @return
     * @throws ParseException
     * @return ModelAndView
     */
    @RequestMapping(value = "/insertPost", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelPostConfirm(@ModelAttribute("postForm") @Valid PostForm postForm, BindingResult result)
            throws ParseException {
        ModelAndView createPostView = new ModelAndView("createPost");
        createPostView.addObject("createPostForm", postForm);
        return createPostView;
    }

    /**
     * <h2>deletePost</h2>
     * <p>
     * Deleting post
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */

    @RequestMapping(value = "/deletePost", method = RequestMethod.GET)
    public ModelAndView deletePost(HttpServletRequest request) {
        int postId = Integer.parseInt(request.getParameter("id"));
        postService.doDeletePost(postId);
        session.setAttribute("completeMsg", messageSource.getMessage("M_SC_0006", null, null));
        return new ModelAndView("redirect:/postList");
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.GET)
    public ModelAndView editPost(@RequestParam("id") Integer postId) throws FileNotFoundException, IOException {
        ModelAndView editView = new ModelAndView("updatePost");
      PostForm postForm  = this.postService.doGetPostById(postId);
        editView.addObject("editPostForm", postForm);
        return editView;
    }

    /**
     * <h2>editPost</h2>
     * <p>
     * Edit post confirm view
     * </p>
     *
     * @param postForm PostForm
     * @param result   BindingResult
     * @return
     * @return ModelAndView
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    @RequestMapping(value = "/updatePostConfirm", method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute("editPostForm") @Valid PostForm postForm, BindingResult result, @RequestParam("imageData") String imageData) throws FileNotFoundException, IOException {
        ModelAndView updateConfirmView = new ModelAndView("updatePost");
        if (result.hasErrors()) {
            updateConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0008", null, null));
            return updateConfirmView;
        }
        /*
         * if (isPostTitleExist) { updateConfirmView.addObject("errorMsg",
         * messageSource.getMessage("M_SC_0018", null, null)); return updateConfirmView;
         * }
         */
        PostForm postById = this.postService.doGetPostById(postForm.getId());
        updateConfirmView = new ModelAndView("updatePostConfirm");
        postForm.setImage(postById.getImage());
       
        if (imageData.length() > 0) {
            postForm.setImage(imageData);
        }
        updateConfirmView.addObject("updatePostForm", postForm);
        return updateConfirmView;
    }

    /**
     * <h2>confirmUpdatePost</h2>
     * <p>
     * Update post in post list
     * </p>
     *
     * @param postForm PostForm
     * @param request  HttpServletRequest
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @SuppressWarnings("deprecation")
    @RequestMapping(value = "/editPost", params = "update", method = RequestMethod.POST)
    public ModelAndView confirmUpdatePost(@ModelAttribute("updatePostForm") @Valid PostForm postForm,
            HttpServletRequest request) throws IOException {
        Path path = Paths.get(request.getRealPath("/") + "/resources/images/" + postForm.getTitle());
        String postImagePath = Files.createDirectories(path) + "/" + postForm.getTitle() + ".png";
        this.postService.doUpdatePost(postForm, postImagePath);
        ModelAndView updatePostView = new ModelAndView("redirect:/postList");
        return updatePostView;
    }

    /**
     * <h2>cancelUpdatePost</h2>
     * <p>
     * Cancel update post
     * </p>
     *
     * @param postForm PostForm
     * @param result   BindingResult
     * @return
     * @throws ParseException
     * @return ModelAndView
     */
    @RequestMapping(value = "/editPost", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelUpdatePost(@ModelAttribute("editPostForm") @Valid PostForm postForm,
            BindingResult result) {
        ModelAndView updatPostView = new ModelAndView("updatePost");
        updatPostView.addObject("editPostForm", postForm);
        return updatPostView;
    }

}
