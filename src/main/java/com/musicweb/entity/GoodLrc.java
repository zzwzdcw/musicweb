package com.musicweb.entity;

public class GoodLrc {
    private int id;
    private String content;
    private String name;
    private String author;

    public GoodLrc(int id, String content, String name, String author) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.author = author;
    }

    public GoodLrc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return content+"——"+name+author;
    }
}
