package com.example.nasos.miniproject1.model;

/**
 * Created by nasos on 2017-07-04.
 */

public class ItemData {

    String comment;
    String name;
    String time;
    String title;
    String content;
    int img;

    public ItemData(String title, String content, int image, String name, String comment, String time) {

        this.comment = comment;
        this.name = name;
        this.time = time;
        this.title = title;
        this.content = content;
        this.img = image;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImg() {
        return img;
    }
}
