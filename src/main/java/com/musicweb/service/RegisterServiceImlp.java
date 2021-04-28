package com.musicweb.service;

import com.musicweb.dao.RegisterDao;
import com.musicweb.entity.UserEntiy;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;

@Service
public class RegisterServiceImlp implements RegisterServiceInterface{


    @Resource
    private RegisterDao registerDao;
    @Override
    public int Register(String name, String account, String pwd) {
        System.out.println("注册"+"name:"+name+"pwd:"+pwd+"account:"+account);
        int flag=registerDao.register(name,DigestUtils.sha3_256Hex(pwd).toUpperCase(Locale.ROOT),account);
        System.out.println("注册成功！"+flag);
        return flag;
    }
}
