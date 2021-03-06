package com.musicweb.dao;

import com.musicweb.entity.GoodLrc;
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

    /**
     * 添加音乐
     * @param name
     * @param time
     * @param music
     * @param author
     * @return
     */
    @Insert("Insert INTO music (name,time,music,author) values(#{name},#{time},#{music},#{author})")
    int AddMusic(String name, String time,String music, String author);

    /**
     * 搜索音乐返回
     * @return
     */
    @Select("Select * from music where name like #{findstr}")
    List<MusicEntiy> selectAllMusicByFind(String findstr);

    /**
     * 获取那个下面的歌词的地儿，没啥意思我感觉
     * @param id
     * @return
     */
    @Select("select * from goodlrc where id = #{id}")
    GoodLrc getonegoodlrc(int id);


    /**
     * 获取该作者的所有的音乐
     * @param author
     * @return
     */
    @Select("select * from music where author = #{author}")
    List<MusicEntiy> selectAllAuthorMusic(String author);
}
