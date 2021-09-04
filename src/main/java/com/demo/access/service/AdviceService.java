package com.demo.access.service;

import com.demo.access.mapper.AdviceMapper;
import com.demo.access.pojo.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 张以恒
 * @create 2021/9/3-11:23
 **/
@Service
public class AdviceService implements AdviceMapper {

    @Autowired
    AdviceMapper adviceMapper;

    public Advice setAdvice(Advice advice) {
        advice.setTime(new Date());
        return advice;
    }

    @Override
    public void saveAdvice(Advice advice) {
        this.adviceMapper.saveAdvice(advice);
    }
}