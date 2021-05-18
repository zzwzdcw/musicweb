package com.musicweb.controller;

import com.musicweb.entity.MusicEntiy;
import com.musicweb.service.MusicServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        model.addAttribute("musicEntiys",musicServiceInterface.selectAllMusic());
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


    @RequestMapping(value = "/findAuthor",method = RequestMethod.GET)
    public String findAuthor(Model model,String author){
        model.addAttribute("musicEntiys", musicServiceInterface.selectAllAuthorMusic(author));
        return "index";
    }

}
