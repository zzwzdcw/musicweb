package com.musicweb.controller;


import com.musicweb.service.RegisterServiceInterface;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

@RestController
public class RegisterController {
//    TODO 29号加进去注册的页面
//     29号去做wintogo了，没做注册页面今天三十号做了
    @Resource
    private RegisterServiceInterface registerServiceInterface;
    @RequestMapping("/register")
    public String Register(String name,String account,String pwd,String pwd2){
        System.out.println("注册服务开始");
        System.out.println("获取到数据："+name+"    "+account+"    "+pwd +"   "+pwd2);
        if (!pwd.equals(pwd2)){
            return "两次密码不匹配错误";
        }
        if ( registerServiceInterface.Register(name,account,pwd,pwd2)!=-1){
            return "注册成功";
        }
        else
            return "error";
    }
    @RequestMapping("/first")
    public String first(){
        return "first SPRINGMVC";
    }
}
