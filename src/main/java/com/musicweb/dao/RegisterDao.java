package com.musicweb.dao;

import com.musicweb.entity.UserEntiy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface RegisterDao {
    /***
     * 注册模块
     * @param name
     * @param pwd
     * @param account
     * @return
     */
    @Insert("insert into user(name,pwd,account) values (#{name},#{pwd},#{account})")
    int register(String name, String pwd, String account);

    /**
     * 注册的时候调用，查看数据库中是否已经存在这个用户。
     * @param  account
     * @return String
     */
    @Select("select account from user where account=#{account}")
    String hasUser(String account);


    /***
     * 普通听众注册模块
     * @param name
     * @param pwd
     * @param account
     * @return
     */
    @Insert("insert into luser(name,pwd,account) values (#{name},#{pwd},#{account})")
    int luserregister(String name, String pwd, String account);

    /**
     * 普通听众注册的时候调用，查看数据库中是否已经存在这个用户。
     * @param  account
     * @return String
     */
    @Select("select account from luser where account=#{account}")
    String luserhasUser(String account);

}
