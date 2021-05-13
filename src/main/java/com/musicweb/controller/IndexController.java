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
public class IndexController {
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

}
