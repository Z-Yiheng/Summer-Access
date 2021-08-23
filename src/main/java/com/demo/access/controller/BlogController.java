package com.demo.access.controller;

import com.demo.access.pojo.Blog;
import com.demo.access.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张以恒
 * @create 2021/8/16-11:00
 **/
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    //map 页显示
    @RequestMapping("/map")
    public String showBlogList(String pageNumber, Model model, ModelMap modelMap) {
        String spPage = pageNumber;
        //每页条数
        int pageSize = 10;
        //页数
        int pageNo = 0;
        if (spPage == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }

        //设置最大页数
        int totalCount = 0;
        int count = blogService.getCount();
        if (count>0) {
            totalCount=count;
        }
        int maxPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        if (pageNo>maxPage) {
            pageNo=maxPage;
        }

        int tempPageNo = (pageNo - 1)*pageSize;

        Map map = new HashMap();
        map.put("pageNo",tempPageNo);
        map.put("pageSize",pageSize);

        List<Blog> list = blogService.pageList(map);
        modelMap.addAttribute("list",list);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("maxPage",maxPage);

        return "map";
    }

    //map 页 删除操作
    @RequestMapping("/deleteBlog/{id}")
    public String deleteBlog (@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/map";
    }

    //main 页 博客显示
    @RequestMapping("/main")
    public String mainShow(ModelMap modelMap) {
        List<Blog> mianlist = blogService.mainblog();
        modelMap.addAttribute("mainlist",mianlist);
        return "/main";
    }


}

