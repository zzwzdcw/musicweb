package com.musicweb.entity;

import org.springframework.stereotype.Component;

@Component
public class MusicEntiy {
    protected int id;
    protected String name;
    protected String author;
    protected String music;

    public MusicEntiy(int id, String name, String author, String music) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.music = music;
    }

    public MusicEntiy(int id) {
        this.id = id;
    }

    public MusicEntiy() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "MusicEntiy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", music='" + music + '\'' +
                '}';
    }
}
