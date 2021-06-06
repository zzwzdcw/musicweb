package com.musicweb.controller;


import com.musicweb.entity.UserEntiy;
import com.musicweb.service.RegisterServiceInterface;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Objects;

@Controller
public class RegisterController {



    @Resource
    private RegisterServiceInterface registerServiceInterface;
    @RequestMapping("/register")
   public String Register(String name,String account,String pwd,String pwd2,Model model){
        System.out.println("注册服务开始");
        System.out.println("获取到数据："+name+"    "+account+"    "+pwd +"   "+pwd2);
        String stat;
        if (!Objects.equals(pwd, pwd2)){
            return "两次密码不匹配错误";
        }
        int flag=registerServiceInterface.Register(name,account,pwd,pwd2);
         if (flag==-2)
        {
            stat="该用户已被注册";
            model.addAttribute("stat",stat);
            return "Register";
        }
        if ( flag==1){
            return "Login";
        }
            return "Login";
    }
    @RequestMapping("/first")
    public String first(){
        return "first SPRINGMVC";
    }

    @RequestMapping("/Register")
    public String Register(){
        return "Register";
    }

    @RequestMapping("/UserInfo")
    public String userinfo(HttpSession session,Model model){
       model.addAttribute("user",registerServiceInterface.getOneUser(Integer.parseInt(session.getAttribute("userId").toString())));
       return "user";
    }

    @RequestMapping("/modUserInfo")
    public String moduserinfo(UserEntiy userEntiy, HttpSession session , Model model){
        UserEntiy getuser = registerServiceInterface.getOneUser(Integer.parseInt(session.getAttribute("userId").toString()));
        getuser.setImg(userEntiy.getImg());
        getuser.setName(userEntiy.getName());
        getuser.setPwd(DigestUtils.sha3_256Hex(userEntiy.getPwd()).toUpperCase(Locale.ROOT));
//TODO 修改账户信息的功能没有做完呢


        return "user";
    }
}

