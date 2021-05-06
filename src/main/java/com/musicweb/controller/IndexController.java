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
        //TODO 这里的东西之后要从数据库获取
        MusicEntiy musicEntiy =new MusicEntiy();
        List<MusicEntiy> musicEntiys = new LinkedList<MusicEntiy>();
        for (int i=0;i<5;i++){
            musicEntiy.setName("歌名："+i);
            musicEntiy.setAuthor("作者 "+ i);
            musicEntiy.setTime("3:00");
            musicEntiy.setId(i+1);
            musicEntiy.setMusic("http://oss.wzszz.top/musicweb/music/%E7%8E%8B%E4%B8%89%E6%BA%A5%20-%20%E5%B9%BB.mp3");
            musicEntiy.setImgb("http://oss.wzszz.top/musicweb/img/imgb.png");
            musicEntiys.add(musicEntiy);
        }

        String name ="二泉映月";
        String time ="3:00";
        String author ="测试文档";

        model.addAttribute("musicEntiys",musicEntiys);

        return "index";

    }

}
