package com.demo.access.service;

import com.demo.access.Utils.MarkdownUtils;
import com.demo.access.mapper.BlogMapper;
import com.demo.access.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 张以恒
 * @create 2021/8/13-10:00
 **/
@Service
public class BlogService implements BlogMapper {

    @Override
    public Blog getAndConvert(int id) {
        Blog blog = blogMapper.findBlog(id);
        String content = blog.getDetail_content();
        blog.setDetail_content(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    @Autowired
    BlogMapper blogMapper;

    //设置点击量和上传时间
    public Blog setBlog(Blog blog) {
        blog.setPublish_time(new Date());
        blog.setViews(0);
        return blog;
    }

    //保存blog
    @Override
    public void saveBlog(Blog blog) {
        this.blogMapper.saveBlog(blog);
    }

    @Override
    public List<Blog> pageList(Map map) {
        return blogMapper.pageList(map);
    }

    @Override
    public int getCount() {
        return blogMapper.getCount();
    }

    @Override
    public void deleteBlog(int id) {
        this.blogMapper.deleteBlog(id);
    }

    @Override
    public Blog findBlog(int id) {
        return blogMapper.findBlog(id);
    }

    @Override
    public List<Blog> mainblog() {
        return blogMapper.mainblog();
    }

    @Override
    public List<Blog> lastest() {
        return blogMapper.lastest();
    }

    @Override
    public int UpdateBlog(int id, String title, String brief_content, String detail_content,Boolean published) {
        return blogMapper.UpdateBlog(id,title,brief_content,detail_content,published);
    }
}