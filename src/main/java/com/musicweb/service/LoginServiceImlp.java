package com.musicweb.service;

import com.musicweb.dao.LoginDao;
import com.musicweb.entity.UserEntiy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class LoginServiceImlp implements LoginServiceInterface{

    @Resource
    protected LoginDao loginDao;
    @Override
    public String login(String account) {

        String PwdInDB;
        try{
            System.out.println("server获取到account："+account);

            UserEntiy user = loginDao.login(account);
            PwdInDB= user.getPwd();
        }
        catch (java.lang.NullPointerException e){
            //如果数据库不存在对应的Account则设置PwdInUser为-1使得提示账号或密码错误！
            PwdInDB = "-1";
            System.out.println(PwdInDB);
        }
        return PwdInDB;
    }

    @Controller
    public class HelloController {
        @RequestMapping("/")
        public String hello(){
            return "forward:Login.html";
        }
    }
}
