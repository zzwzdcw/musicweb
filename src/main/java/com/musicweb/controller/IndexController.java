package com.musicweb.controller;

import com.musicweb.entity.MusicEntiy;
import com.musicweb.service.MusicServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
public class IndexController{
    @Resource
    private MusicServiceInterface musicServiceInterface;



    /**
     * 首页的展示
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String hello(Model model){

        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();
        model.addAttribute("musicEntiys",musicEntiys);

        return "index";
 
    }

    /**
     *模糊查询歌曲
     * @param model
     * @param findstr
     * @return
     */
    @RequestMapping("/findMusic")
    public String findmusic(Model model ,String findstr){
        model.addAttribute("musicEntiys",musicServiceInterface.selectAllMusicByFind(findstr));
        return "index";
    }

    @RequestMapping("/goodlrc")
    public String goodlrc(Model model){
        model.addAttribute("str",musicServiceInterface.getonegoodlrc());
        return "iframeshow";
    }

}
