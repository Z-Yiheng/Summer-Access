package com.demo.access.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张以恒
 * @create 2021/8/10-10:20
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/advice").setViewName("advice");
        registry.addViewController("/back").setViewName("back");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/404").setViewName("404");
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/main",
                        "/blog/**",
                        "/background",
                        "/login",
                        "/CSS/**",
                        "/JS/**",
                        "/Utils/**",
                        "/img/**",
                        "/**.ico",
                        "/images/**",
                        "/404",
                        "/advice",
                        "/updateadvice",
                        "/back",
                        "/Music/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path= "D:/张以恒/桌面/Summer-Access/src/main/resources/static/images/";
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path);
    }
}