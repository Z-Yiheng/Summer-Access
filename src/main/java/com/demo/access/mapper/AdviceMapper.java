package com.demo.access.mapper;

import com.demo.access.pojo.Advice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张以恒
 * @create 2021/9/3-11:13
 **/
@Mapper
@Repository
public interface AdviceMapper {

    @Insert(value = "insert into advice (id,name,way,number,advice,time) " +
            "values (#{id},#{name},#{way},#{number},#{advice},#{time})")
    void saveAdvice(Advice advice);
}
