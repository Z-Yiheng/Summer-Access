package com.demo.access.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张以恒
 * @create 2021/8/5-16:07
 **/
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/publish")
    public String publish() {
        return "publish";
    }
}
