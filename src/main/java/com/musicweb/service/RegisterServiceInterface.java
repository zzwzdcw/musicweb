package com.musicweb.service;

import com.musicweb.entity.UserEntiy;

public interface RegisterServiceInterface {

    int Register(String name,String account,String pwd,String pwd2);

    UserEntiy getOneUser(int userid);

}
