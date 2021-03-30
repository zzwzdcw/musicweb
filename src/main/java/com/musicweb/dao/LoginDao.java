package com.musicweb.dao;

import com.musicweb.entity.UserEntiy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    /***
     * 登录
     * @param account
     * @return
     */
    @Select("select pwd from user where account=#{account} ")
    UserEntiy login(String account);



}
