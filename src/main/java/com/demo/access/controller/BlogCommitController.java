package com.demo.access.controller;

import com.demo.access.pojo.Blog;
import com.demo.access.service.BlogService;
import com.demo.access.service.ImgService;
import com.demo.access.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author 张以恒
 * @create 2021/8/13-10:01
 **/
@Controller
public class BlogCommitController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ImgService imgService;

    @PostMapping("/insertBlog")
    public String insertBlog(HttpServletRequest request) throws IOException {

        Blog blog1 = new Blog();

        //给 blog1 设定值
        blog1.setTitle(request.getParameter("title"));
        blog1.setBrief_content(request.getParameter("briefContent"));
        blog1.setDetail_content(request.getParameter("detailContent"));
        blog1.setPublished(Boolean.parseBoolean(request.getParameter("published")));

        //文件操作
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,MultipartHttpServletRequest.class);
        MultipartFile file = multipartRequest.getFile("file");
        blog1.setFirst_picture(imgService.uploadImage(file));

        //保存到数据库
        blogService.saveBlog(blogService.setBlog(blog1));

        return "redirect:/map";
    }

}