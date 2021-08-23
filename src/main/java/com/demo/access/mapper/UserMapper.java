package com.demo.access.mapper;

import com.demo.access.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;



/**
 * @author 张以恒
 * @create 2021/8/9-14:52
 **/
@Repository
@Mapper
public interface UserMapper {

    User checkUser(String username);

    @Select(value = "select * from user where username = #{username}")
    User USER_LIST(@Param("username") String username);

    @Update("update user set othername = #{othername}," +
                            "phonenumber = #{phonenumber}," +
                            "qq = #{qq}," +
                            "wechat = #{wechat}")
    int UpdateUser(User user);
}