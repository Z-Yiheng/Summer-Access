package com.demo.access.service;

import com.demo.access.mapper.UserMapper;
import com.demo.access.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张以恒
 * @create 2021/8/9-14:55
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean login(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = userMapper.checkUser(username);

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

}