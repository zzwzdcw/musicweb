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
    protected RegisterDao registerDao;
    @Override
    public int Register(String name, String account, String pwd,String pwd2) {

            System.out.println("注册"+"name:"+name+"pwd:"+pwd+"account:"+account+"pwd2"+pwd2);


            if (registerDao.hasUser(account)==account)
            {
                //该用户名已经存在
                return -2;
            }
            int flag=registerDao.register(name,DigestUtils.sha3_256Hex(pwd).toUpperCase(Locale.ROOT),account);
            if (flag!=-1)
            {
                System.out.println("注册成功！"+flag);
                return flag;
            }else {
                return -1;
            }
    }
}
