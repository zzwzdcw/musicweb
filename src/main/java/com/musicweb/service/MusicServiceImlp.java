package com.musicweb.service;

import com.musicweb.dao.MusicDAO;
import com.musicweb.entity.MusicEntiy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


@Service
public class MusicServiceImlp implements MusicServiceInterface{

    @Resource
    protected MusicDAO MusicDAO;


    @Override
    public List<MusicEntiy> selectAllMusic() {
        List<MusicEntiy> musicEntiyList =MusicDAO.selectAllMusic();
        return musicEntiyList;
    }

    @Override
    public int delOneMusicByID(int id) {
        int flag= MusicDAO.delOneMusicByID(id);
        if (flag==1){
            return flag;
        }
        return 0;

    }


}
