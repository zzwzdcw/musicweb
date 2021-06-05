package com.musicweb.entity;

public class LuserEntiy {

    protected int id;
    protected String name;
    protected String pwd;
    protected String account;
    protected String img;

    public LuserEntiy(String name, String pwd, String account) {
        this.name = name;
        this.pwd = pwd;
        this.account = account;
    }

    public LuserEntiy(String pwd, String account) {
        this.pwd = pwd;
        this.account = account;
    }

    public LuserEntiy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
