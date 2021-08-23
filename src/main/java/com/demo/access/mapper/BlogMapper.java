package com.demo.access.mapper;

import com.demo.access.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author 张以恒
 * @create 2021/8/13-10:00
 **/
@Repository
@Mapper
public interface BlogMapper {

    //保存博客信息
    void saveBlog(Blog blog);

    //查找博客分页查询
    @Select(value = "select * from my_blog limit #{pageNo},#{pageSize}")
    List<Blog> pageList(Map map);

    //查看全部博客
    @Select(value = "select *from my_blog")
    List<Blog> mainblog();

    //博客查询总数
    @Select(value = "select count(*) from my_blog")
    int getCount();

    //博客删除
    void deleteBlog(@Param("id") int id);

}