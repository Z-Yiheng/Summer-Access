package com.demo.access.mapper;

import com.demo.access.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张以恒
 * @create 2021/8/9-14:52
 **/
@Repository
@Mapper
public interface UserMapper {

    User checkUser(String username);

}