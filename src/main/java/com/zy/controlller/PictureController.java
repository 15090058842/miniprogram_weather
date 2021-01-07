package com.zy.controlller;

import com.zy.entity.WXResult;
import com.zy.service.IMAGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    IMAGEService imageService;
    @RequestMapping("/uplode")
    public WXResult pictureUpload(MultipartFile file){

        return imageService.uploadPicture(file);

    }

}
