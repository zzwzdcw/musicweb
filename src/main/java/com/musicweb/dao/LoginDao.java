package com.musicweb.dao;

import com.musicweb.entity.LuserEntiy;
import com.musicweb.entity.UserEntiy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface LoginDao {
    /**
     * 登录
     * @param account
     * @return
     */
    @Select("select * from user where account=#{account} ")
    UserEntiy login(String account);


    /**
     * 查询登录账号的角色
     * @param account
     * @return
     */
    @Select("select role from user where account=#{account}")
    int selectRole(String account);
    /**
     * 听众的登录
     * @param account
     * @return
     */
    @Select("select pwd from luser where account=#{account} ")
    LuserEntiy llogin(String account);


}
