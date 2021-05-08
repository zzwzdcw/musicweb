package com.musicweb.controller;

import com.musicweb.entity.MusicEntiy;
import com.musicweb.service.MusicServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class backstageController {
    @Resource
    private MusicServiceInterface musicServiceInterface;

    @RequestMapping("/background/backstage")
    public String hello(Model model){
        //TODO 这里的东西之后要从数据库获取

        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();

        model.addAttribute("musicEntiys",musicEntiys);

        return "backstage";

    }

    @RequestMapping("/delonemusic")
    public String delOneMusic(int id,Model model){
        if (musicServiceInterface.delOneMusicByID(id)==0)
        {
        return "error";
        }
        this.hello(model);
        return "backstage.html";
    }
}
