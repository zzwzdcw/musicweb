package com.musicweb.service;

public interface LoginServiceInterface {
    /***
     * 登录功能
     * @param account
     * @return
     */
    public String login(String account);

    /***
     * 听众登录功能
     * @param account
     * @return
     */
    public String llogin(String account);


    int selectRole(String account);
}
