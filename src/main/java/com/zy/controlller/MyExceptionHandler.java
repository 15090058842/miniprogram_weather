package com.zy.controlller;

import com.zy.entity.WXResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public WXResult error(Exception e){
        e.printStackTrace();
        return WXResult.fail();
    }
}
