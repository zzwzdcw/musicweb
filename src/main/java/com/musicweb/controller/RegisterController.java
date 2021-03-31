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

        registerServiceInterface.Register(name, account, DigestUtils.sha3_256Hex(pwd).toUpperCase(Locale.ROOT));
        return "自己看去";
    }

}
