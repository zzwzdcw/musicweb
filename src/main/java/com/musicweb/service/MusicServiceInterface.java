package com.musicweb.service;

import com.musicweb.entity.GoodLrc;
import com.musicweb.entity.MusicEntiy;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MusicServiceInterface {

    List<MusicEntiy> selectAllMusic();

    int delOneMusicByID(int id);

    int AddMusic(String name,String time,String InputFile,String author);

    List<MusicEntiy>  selectAllMusicByFind(String findstr);

    String getonegoodlrc();

    List<MusicEntiy> selectAllAuthorMusic(String author);

}
