package com.demo.access.mapper;

import com.demo.access.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张以恒
 * @create 2021/8/13-10:00
 **/
@Repository
@Mapper
public interface BlogMapper {

    void saveBlog(Blog blog);

}