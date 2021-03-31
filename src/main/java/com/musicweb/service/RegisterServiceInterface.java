package com.musicweb.service;

import com.musicweb.entity.UserEntiy;

public interface RegisterServiceInterface {

    UserEntiy Register(String name,String account,String pwd);
}
