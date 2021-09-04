package com.demo.access.controller;

import com.demo.access.pojo.Advice;
import com.demo.access.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 张以恒
 * @create 2021/9/3-11:28
 **/
@Controller
public class AdviceController {

    @Autowired
    AdviceService adviceService;

    @RequestMapping( value = "/updateadvice",
            method = RequestMethod.POST)
    public String InsertAdvice(HttpServletRequest httpServletRequest, Model model) {
        Advice advice = new Advice();

        advice.setName(httpServletRequest.getParameter("name"));
        advice.setWay(httpServletRequest.getParameter("way"));
        advice.setNumber(httpServletRequest.getParameter("number"));
        advice.setAdvice(httpServletRequest.getParameter("advice"));

        adviceService.saveAdvice(adviceService.setAdvice(advice));
        model.addAttribute("msg","上传成功");
        return "/back";

    }
}