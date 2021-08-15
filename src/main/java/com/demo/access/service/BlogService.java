package com.demo.access.service;

import com.demo.access.mapper.BlogMapper;
import com.demo.access.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 张以恒
 * @create 2021/8/13-10:00
 **/
@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;


    public Blog setBlog(Blog blog) {
        blog.setPublish_time(new Date());
        blog.setViews(0);
        return blog;
    }

    public void saveBlog(Blog blog) {
        blogMapper.saveBlog(blog);
    }
}