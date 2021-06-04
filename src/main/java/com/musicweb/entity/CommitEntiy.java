package com.musicweb.entity;

import java.sql.Timestamp;

public class CommitEntiy  {
    protected int id;
    protected int musiceid;
    protected int userid;
    protected String img;
    protected String content;
    protected String creatTime;
    protected String name;

    public CommitEntiy() {
    }

    public CommitEntiy(int musiceid, int userid, String img, String content, String creatTime) {
        this.musiceid = musiceid;
        this.userid = userid;
        this.img = img;
        this.content = content;
        this.creatTime = creatTime;
    }

    public CommitEntiy(int id, int musiceid, int userid, String content) {
        this.id = id;
        this.musiceid = musiceid;
        this.userid = userid;
        this.content = content;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
//        this.creatTime = "'"+creatTime+"'";
        this.creatTime = creatTime;
    }

    public CommitEntiy(int id, int musiceid, int userid, String img, String content) {
        this.id = id;
        this.musiceid = musiceid;
        this.userid = userid;
        this.img = img;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public CommitEntiy(int musiceid, int userid, String img, String content, String creatTime, String name) {
        this.musiceid = musiceid;
        this.userid = userid;
        this.img = img;
        this.content = content;
        this.creatTime = creatTime;
        this.name = name;
    }

    public CommitEntiy(int id, int musiceid, int userid, String img, String content, String creatTime, String name) {
        this.id = id;
        this.musiceid = musiceid;
        this.userid = userid;
        this.img = img;
        this.content = content;
        this.creatTime = creatTime;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMusiceid() {
        return musiceid;
    }

    public void setMusiceid(int musiceid) {
        this.musiceid = musiceid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
//        this.img = "'"+img+"'";
        this.img = img;
    }

    public void setContent(String content) {
//        this.content = "'"+content+"'";
        this.content = content;
    }




}
