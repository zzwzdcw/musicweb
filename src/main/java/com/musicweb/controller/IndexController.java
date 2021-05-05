package com.musicweb.controller;

import com.musicweb.entity.MusicEntiy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(Model model){
        MusicEntiy musicEntiy =new MusicEntiy();
        List<MusicEntiy> musicEntiys = new LinkedList<MusicEntiy>();
        for (int i=0;i<5;i++){
            musicEntiy.setName("歌名："+i);
            musicEntiy.setAuthor("作者 "+ i);
            musicEntiy.setTime("3:00");
            musicEntiy.setId(i+1);
            musicEntiys.add(musicEntiy);
        }

        String name ="二泉映月";
        String time ="3:00";
        String author ="测试文档";

        model.addAttribute("musicEntiys",musicEntiys);

        return "index";

//        return "forward:index.html";

    }

}
