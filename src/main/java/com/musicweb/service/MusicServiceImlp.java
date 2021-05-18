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

    /**
     * 获取所有的音乐
     * @return
     */
    @Override
    public List<MusicEntiy> selectAllMusic() {
        List<MusicEntiy> musicEntiyList =MusicDAO.selectAllMusic();
        return musicEntiyList;
    }

    /**
     * 通过id来删除一个音乐
     * @param id
     * @return
     */
    @Override
    public int delOneMusicByID(int id) {
        int flag= MusicDAO.delOneMusicByID(id);
        if (flag==1){
            return flag;
        }
        return 0;

    }


    /**
     * 添加一个音乐到数据库中，name自动去掉后缀
     * @param name
     * @param time
     * @param InputFile
     * @param author
     * @return
     */
    @Override
    public int AddMusic(String name, String time,String InputFile, String author) {

        String music="http://oss.wzszz.top/"+oss.musicFileSimpUp(InputFile,name);
        System.out.println(music);
        name=name.replaceAll(".mp3|.flac","");
        if (MusicDAO.AddMusic(name,time,music,author)!=1){
            return 0;
        }
        return 1;
    }


    /**
     * 用搜索框查找音乐
     * @param findstr
     * @return
     */
    @Override
    public List<MusicEntiy> selectAllMusicByFind(String findstr) {
        findstr="%"+findstr+"%";
       return MusicDAO.selectAllMusicByFind(findstr);
    }

    /**
     * 歌词显示
     * @return
     */
    @Override
    public String getonegoodlrc() {
        final long l = System.currentTimeMillis();
        final int i = (int)( l % (MAX_GOODLRC_LINE-1) )+1;
        return MusicDAO.getonegoodlrc(i).toString();
    }


    /**
     * 查看这个作者的所有的音乐
     * @param author
     * @return
     */
    @Override
    public List<MusicEntiy> selectAllAuthorMusic(String author) {
        System.out.println(author);
        return MusicDAO.selectAllAuthorMusic(author);
    }
}
