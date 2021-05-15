package com.musicweb.service;

import com.musicweb.dao.MusicDAO;
import com.musicweb.entity.GoodLrc;
import com.musicweb.entity.MusicEntiy;
import com.musicweb.tool.oss;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



@Service
public class MusicServiceImlp implements MusicServiceInterface{

    /**
     * goodlrc表的上限
     */
    final int MAX_GOODLRC_LINE = 9;


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

    @Override
    public List<MusicEntiy> selectAllMusicByFind(String findstr) {
        findstr="%"+findstr+"%";
       return MusicDAO.selectAllMusicByFind(findstr);
    }

    @Override
    public String getonegoodlrc() {
        final long l = System.currentTimeMillis();
        final int i = (int)( l % (MAX_GOODLRC_LINE-1) )+1;
        return MusicDAO.getonegoodlrc(i).toString();
    }


}
