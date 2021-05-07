package com.musicweb.controller;


import com.musicweb.service.RegisterServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
public class RegisterController {



    @Resource
    private RegisterServiceInterface registerServiceInterface;
    @RequestMapping("/register")
   public String Register(String name,String account,String pwd,String pwd2,Model model){
//        public String Register(Model model){

//        String name= (String) model.getAttribute("namne");
//        String pwd=(String)model.getAttribute("pwd");
//        String pwd2=(String)model.getAttribute("pwd2");
//        String account = (String) model.getAttribute("account");

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
            return "Register";
        }
            return "Login.html";
    }
    @RequestMapping("/first")
    public String first(){
        return "first SPRINGMVC";
    }

    @RequestMapping("/Register")
    public String Register(){
        return "Register";
    }
}
