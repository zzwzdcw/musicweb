package com.musicweb.service;

import com.musicweb.dao.RegisterDao;
import com.musicweb.entity.UserEntiy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImlp implements RegisterServiceInterface{
    @Resource
    private RegisterDao registerDao;
    @Override
    public UserEntiy Register(String name, String account, String pwd) {
        System.out.println("注册"+name+pwd+account);
        registerDao.register(name,pwd,account);

        return null;
    }
}
