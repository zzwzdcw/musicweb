package com.musicweb.controller;

import com.musicweb.entity.CommitEntiy;
import com.musicweb.service.CommitServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class CommitController {

    @Resource
    CommitServiceInterface commitServiceInterface;

    @RequestMapping(value = "/commit/getCommit",method = RequestMethod.GET)
    public String getAllCommit(int musiceId, Model model,HttpSession session){
        System.out.println("查看评论："+musiceId);
        List<CommitEntiy> ComitEntiysList = commitServiceInterface.selectAllCommit(musiceId);
        model.addAttribute("CommitEntiys", ComitEntiysList);
        session.setAttribute("musicId",musiceId);//将musicid存入session中方便添加评论使用
        System.out.println("返还给前端");
        return "commit";
    }

    @RequestMapping(value = "/commit/addCommit",method = RequestMethod.POST)
    public String addCommit(String Content, HttpSession session , Model model){
        //如果没有登录就返回原网页
        if (session.getAttribute("userId") == null)
        {
            this.getAllCommit((Integer) session.getAttribute("musicId"),model,session);
            return "commit";
        }

        CommitEntiy commitEntiy=new CommitEntiy();
        commitEntiy.setContent(Content);
        commitEntiy.setMusiceid((Integer) session.getAttribute("musicId"));
        commitEntiy.setUserid((Integer)session.getAttribute("userId"));
        java.util.Date date = new java.util.Date();//获取一个Date对象
        Timestamp timeStamp = new Timestamp(date.getTime());//将日期时间转换为数据库中的timestamp类型
        commitEntiy.setCreatTime(String.valueOf(timeStamp));
        commitServiceInterface.addCommit(commitEntiy);
        return "commit";

    }

}
