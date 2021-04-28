package com.musicweb.controller;


import com.musicweb.service.RegisterServiceInterface;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

@RestController
public class RegisterController {
    @Resource
    private RegisterServiceInterface registerServiceInterface;
    @RequestMapping("/register")
    public String Register(String name,String pwd,String account){
        System.out.println("注册服务开始");
        if ( registerServiceInterface.Register(name,account,pwd)==1){
            return "注册成功";

        }
        else
            return "error";
    }

}
