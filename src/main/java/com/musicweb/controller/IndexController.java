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

    @RequestMapping("/")
    public String hello(Model model){

        List<MusicEntiy> musicEntiys =musicServiceInterface.selectAllMusic();
        String name ="二泉映月";
        String time ="3:00";
        String author ="测试文档";

        model.addAttribute("musicEntiys",musicEntiys);

        return "index";

    }

}
