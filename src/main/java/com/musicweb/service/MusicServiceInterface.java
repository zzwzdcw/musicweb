package com.musicweb.service;

import com.musicweb.entity.MusicEntiy;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MusicServiceInterface {

    List<MusicEntiy> selectAllMusic();

    int delOneMusicByID(int id);


}
