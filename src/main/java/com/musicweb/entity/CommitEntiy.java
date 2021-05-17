package com.musicweb.entity;

public class CommitEntiy {
    private int id;
    private int musiceid;
    private int userid;
    private String content;

    public CommitEntiy() {
    }

    public CommitEntiy(int id, int musiceid, int userid, String content) {
        this.id = id;
        this.musiceid = musiceid;
        this.userid = userid;
        this.content = content;
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

    public void setContent(String content) {
        this.content = content;
    }


}
