package com.demo.access.mapper;

import com.demo.access.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    //将 markdown 转换为 html
    Blog getAndConvert(int id);

    //保存博客信息
    void saveBlog(Blog blog);

    //查找博客分页查询
    @Select(value = "select * from my_blog limit #{pageNo},#{pageSize}")
    List<Blog> pageList(Map map);

    //查看全部博客
    @Select(value = "select *from my_blog where published = true")
    List<Blog> mainblog();

    //博客查询总数
    @Select(value = "select count(*) from my_blog")
    int getCount();

    //博客删除
    void deleteBlog(@Param("id") int id);

    //编辑博客
    @Update(value = "update my_blog set title = #{title}," +
                                        "brief_content = #{brief_content}," +
                                        "detail_content = #{detail_content}," +
                                        "published = #{published} " +
                                        "where id = #{id}")
    int UpdateBlog(@Param("id") int id,String title,String brief_content,String detail_content,Boolean published);

    //具体博客查找
    @Select(value = "select * from my_blog where id = #{id}")
    Blog findBlog(@Param("id") int id);

    //查询最新的三条数据
    @Select(value = "select * from my_blog where published = true order by publish_time desc limit 0,3")
    List<Blog> lastest();

}