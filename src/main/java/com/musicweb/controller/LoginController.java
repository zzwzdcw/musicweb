package com.musicweb.controller;

import com.musicweb.service.LoginServiceInterface;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;



@Controller
public class LoginController {
    @Resource
    private LoginServiceInterface loginServiceInterface;
    @Resource
    private backstageController backstageController;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String account ,String pwd, Model model){
        System.out.println("login登录开始");
        System.out.println("account:"+account+"pwd:"+pwd);
        //ModelAndView mv = new ModelAndView();
        String pwdInDB = loginServiceInterface.login(account);
        String userCinPwd = DigestUtils.sha3_256Hex(pwd).toUpperCase(Locale.ROOT);
        if (userCinPwd.equals(pwdInDB)) {
            System.out.println("密码正确");
            backstageController.hello(model);
        return "/backstage";
        }
       // return mv;
        return "forward:Login.html";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String Login(  ){
        return "Login";
    }

    @RequestMapping("/loginout")
    public String loginout (HttpSession session){
//        session.
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
