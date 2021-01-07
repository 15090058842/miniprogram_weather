package com.zy.controlller;


import com.zy.entity.SKOpenId;
import com.zy.entity.WXResult;
import com.zy.util.HttpClientUtil;
import com.zy.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@PropertySource("classpath:resource.properties")
@RequestMapping("/user")
public class LoginController {
    @Value("${WX_USER_URL}")
    String  WX_USER_URL;
    @Value("${WX_APPID}")
    String WX_APPID;
    @Value("${WX_APPSECRET}")
    String WX_APPSECRET;
    @Value("${WX_GRANT_TYPE}")
    String WX_GRANT_TYPE;

    @RequestMapping(value = "/login/{code}",method = RequestMethod.GET)
    public WXResult checkLoginInfo(@PathVariable String code){
        WXResult wxResult = new WXResult();
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("appid",WX_APPID);
        param.put("secret",WX_APPSECRET);
        param.put("js_code",code);
        param.put("grant_type",WX_GRANT_TYPE);
        String s = HttpClientUtil.doGet(WX_USER_URL, param);
        System.out.println("远程调用获取"+s);
        if (s!=null&&!"".equals(s)){
            SKOpenId pojo = JsonUtils.jsonToPojo(s, SKOpenId.class);
            System.out.println("转换后"+pojo.toString());
            wxResult.setErrcode(0);
            wxResult.setErrmsg("验证成功");
            wxResult.setData(pojo);
        }else {
            wxResult.setErrcode(-1);
            wxResult.setErrmsg("系统繁忙，此时请开发者稍候再试");
        }
        return wxResult;
    }
}
