package com.musicweb.dao;

import com.musicweb.entity.MusicEntiy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicDAO {
    /**
     * 后期不会用到
     * @return
     */
    @Select("Select * from music ")
    List<MusicEntiy> selectAllMusic();

    /**
     *根据id删除音乐文件
     * 仅删除数据库中的记录，不对oss中的数据进行操作
     * @return
     */
    @Delete("DELETE FROM music WHERE id=#{id}")
    int delOneMusicByID(int id);

    /**
     * 插入一个音乐数据到数据库
     * @param name
     * @param time
     * @param music
     * @param author
     * @return
     */

//    @Insert("insert into user(name,pwd,account) values (#{name},#{pwd},#{account})")

    @Insert("Insert INTO music (name,time,music,author) values(#{name},#{time},#{music},#{author})")
    int AddMusic(String name, String time,String music, String author);
}
