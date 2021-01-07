package com.zy.service;

import com.zy.entity.WXResult;
import com.zy.util.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Transactional
public class IMAGEService {
    @Value("${FTP_ADDRESS}")
    String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    Integer FTP_PORT;
    @Value("${FTP_USER_NAME}")
    String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    String IMAGE_BASE_URL;

    public WXResult uploadPicture(MultipartFile multipartFile){

        try {
            //等到原文件名
            String oldFilename = multipartFile.getOriginalFilename();
            System.out.println("旧文件名"+oldFilename);
            String newFileName = UUID.randomUUID().toString();
            newFileName = newFileName+oldFilename.substring(oldFilename.lastIndexOf("."));
            System.out.println("新文件名"+newFileName);
            //文件上传
            SimpleDateFormat format = new SimpleDateFormat("/yyyy/MM/dd");
            String imagePath = format.format(new Date());
            System.out.println("图片路径"+imagePath);
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath, newFileName, multipartFile.getInputStream());
            System.out.println("result:"+result);
            if (result){
                WXResult.ok();
            }
        }catch (Exception e){
            System.out.println("文件上传出错"+e.getMessage());
            e.printStackTrace();
        }
        return WXResult.fail();
    }

}
