package com.musicweb.service;

import com.musicweb.entity.UserEntiy;

public interface LoginServiceInterface {
    /***
     * 登录功能
     * @param account
     * @return
     */
    public UserEntiy login(String account);

    /***
     * 听众登录功能
     * @param account
     * @return
     */
    public String llogin(String account);


    int selectRole(String account);
}
