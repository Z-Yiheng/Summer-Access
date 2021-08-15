package com.demo.access.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 张以恒
 * @create 2021/8/11-10:56
 **/

//暂时没用
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //重新自定义登录页面
        http.formLogin()
                .loginPage("login.html");

        //授权
        http.authorizeRequests()
                //放行登陆界面
                .antMatchers("/").permitAll();
    }

    @Bean
    public PasswordEncoder pw() {
         return new BCryptPasswordEncoder();
     }
}