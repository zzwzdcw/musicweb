package com.musicweb.entity;

import org.springframework.stereotype.Component;

@Component
public class UserEntiy {
    protected int id;
    protected String name;
    protected String pwd;
    protected String account;
    protected String img;

    public String getImg() {
        return img;
    }

    public UserEntiy(int id, String name, String pwd, String account, String img) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.account = account;
        this.img = img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public UserEntiy() {
    }

    public UserEntiy(int id, String name, String pwd, String account) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.account = account;
    }

    public UserEntiy(String pwd, String account) {
        this.pwd = pwd;
        this.account = account;
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

    @Override
    public String toString() {
        return "UserEntiy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
