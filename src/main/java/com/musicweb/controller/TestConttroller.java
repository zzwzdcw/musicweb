package com.musicweb.controller;

import com.musicweb.entity.MusicEntiy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 本类为测试类
 */
@Controller
public class TestConttroller {
    @RequestMapping("/Test")
    public String Test(String name,String time,String InputFile,String author,Model model){


        return "index";
    }
    @RequestMapping("/test")
    public String test(Model model){

        return "test";
    }


}
