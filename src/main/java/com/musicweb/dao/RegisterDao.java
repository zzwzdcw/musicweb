package com.musicweb.dao;

import com.musicweb.entity.UserEntiy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterDao {
    /***
     * 注册模块
     * @param name
     * @param pwd
     * @param account
     * @return
     */
    @Insert("insert into user(name,pwd,account) values (#{name},#{pwd},#{account})")
    UserEntiy register(String name, String pwd, String account);

}
