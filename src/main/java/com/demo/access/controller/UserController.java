package com.demo.access.controller;

import com.demo.access.pojo.User;
import com.demo.access.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/login",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    @ResponseBody
    public Map<String ,Object> check(@RequestBody User user) {
        Map<String ,Object> map = new HashMap<>();
        if (userService.login(user)==true) {
            map.put("result","success");
        } else {
            map.put("result","fail");
        }
        return map;
    }

}