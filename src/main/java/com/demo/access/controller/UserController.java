package com.demo.access.controller;

import com.demo.access.pojo.User;
import com.demo.access.service.ImgService;
import com.demo.access.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张以恒
 * @create 2021/8/9-15:16
 **/
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = userService.checkUser(username);
        if(user1==null) {
            return false;
        } else {
            if(user1.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @RequestMapping(value = "/login",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    @ResponseBody
    public Map<String ,Object> check(@RequestBody User user, HttpSession session, Model model) {
        Map<String ,Object> map = new HashMap<>();
        if (login(user)==true) {
            session.setAttribute("username",user.getUsername());
            map.put("result","success");
        } else {
            map.put("result","fail");
        }
        return map;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {

        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/main";
    }

    @RequestMapping(value = "/published")
    public String showPublish(ModelMap modelMap) {

        String username = (String) httpSession.getAttribute("username");
        modelMap.addAttribute("person",userService.USER_LIST(username));

        return "/published";
    }

}