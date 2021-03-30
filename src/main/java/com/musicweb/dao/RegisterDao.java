package com.musicweb.dao;

import org.apache.ibatis.annotations.Insert;

public interface RegisterDao {
    /***
     * 注册模块
     * @param name
     * @param pwd
     * @param account
     * @return
     */
    @Insert("insert ")
    public int register(String name,String pwd, String account);
}
