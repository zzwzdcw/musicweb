package com.musicweb.service;

import com.musicweb.dao.MusicDAO;
import com.musicweb.entity.MusicEntiy;
import com.musicweb.tool.oss;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public int AddMusic(String name, String time,String InputFile, String author) {

        String music="http://oss.wzszz.top/"+oss.musicFileSimpUp(InputFile,name);
        System.out.println(music);
        if (MusicDAO.AddMusic(name,time,music,author)!=1){
            return 0;
        }
        return 1;
    }


}
