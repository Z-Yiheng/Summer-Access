package com.demo.access.controller;

import com.demo.access.pojo.User;
import com.demo.access.service.BlogService;
import com.demo.access.service.ImgService;
import com.demo.access.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张以恒
 * @create 2021/8/24-11:03
 **/
@Controller
public class UserDoController {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    BlogService blogService;

    @Autowired
    private ImgService imgService;

    @RequestMapping("/background")
    public String showBackground(HttpSession httpSession) {
        if (httpSession.getAttribute("username")==null) {
            return "/login";
        } else {
            return "redirect:/personal";
        }
    }

    @RequestMapping("/personal")
    public String personWeb(ModelMap modelMap) {
        String username = (String)  httpSession.getAttribute("username");
        User person = userService.USER_LIST(username);
        modelMap.addAttribute("person",person);
        return "/personal";
    }

    @PostMapping("/person")
    public String uploadInf(HttpServletRequest request, User user) {
        User newUser = new User();

        newUser.setOthername(request.getParameter("othername"));
        newUser.setPhonenumber(request.getParameter("phonenumber"));
        newUser.setQq(request.getParameter("qq"));
        newUser.setWechat(request.getParameter("wechat"));

        userService.UpdateUser(newUser);

        return "redirect:/personal";
    }

    @PostMapping("/uploadImg")
    public String uploadImg(HttpServletRequest request) {
        User newUserImg = new User();

        //文件操作
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,MultipartHttpServletRequest.class);
        MultipartFile file = multipartRequest.getFile("file");
        newUserImg.setLogo(imgService.uploadImage(file));

        userService.UpdateLogo(newUserImg);

        return "redirect:/personal";
    }

    @PostMapping("/updateBlog/{id}")
    public String uploadBlog(HttpServletRequest request, @PathVariable int id) {
        blogService.UpdateBlog(
                id,
                request.getParameter("title"),
                request.getParameter("briefContent"),
                request.getParameter("detailContent"),
                Boolean.valueOf(request.getParameter("published")));
        return "redirect:/map";
    }
}