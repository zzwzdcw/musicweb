package com.musicweb.dao;

import com.musicweb.entity.MusicEntiy;
import org.apache.ibatis.annotations.Delete;
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
}
