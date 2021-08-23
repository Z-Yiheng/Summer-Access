package com.demo.access.service;

import com.demo.access.mapper.UserMapper;
import com.demo.access.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张以恒
 * @create 2021/8/9-14:55
 **/
@Service
public class UserService implements UserMapper{

    @Autowired
    UserMapper userMapper;


    @Override
    public int UpdateUser(User user) {
        return userMapper.UpdateUser(user);
    }

    @Override
    public User checkUser(String username) {
        return userMapper.checkUser(username);
    }

    @Override
    public User USER_LIST(String username) {
        return userMapper.USER_LIST(username);
    }
}