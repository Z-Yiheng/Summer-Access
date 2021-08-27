package com.demo.access.service;

import org.springframework.stereotype.Service;
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

        String fileName = file.getOriginalFilename();

        File pfile = new File("D:/张以恒/桌面/Summer-Access/src/main/resources/static/images/");
        if (!pfile.exists()) {
            pfile.mkdirs();
        }

        File saveFile = new File(pfile,fileName);

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

}