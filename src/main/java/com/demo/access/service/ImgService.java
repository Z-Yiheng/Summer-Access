package com.demo.access.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 张以恒
 * @create 2021/8/15-11:35
 **/
@Service
public class ImgService {
    //图片处理，返回访问地址
    public String uploadImage(MultipartFile file) {
        //获取本地地址
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();

        String url_path = "images" + File.separator + fileName;
        //图片保存地址
        String savePath = staticPath + File.separator + url_path;
        System.out.println("图片保存地址:" + savePath);
        //访问地址即存储到数据库的地址
        String visitPath = "static/" + url_path;
        System.out.println("图片访问url：" + visitPath);
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return visitPath;
    }
}