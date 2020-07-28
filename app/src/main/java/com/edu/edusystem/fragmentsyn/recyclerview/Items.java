package com.edu.edusystem.fragmentsyn.recyclerview;

import android.widget.ImageView;

public class Items {
    String title;
    String time;
    String many;
    String money;
    int teacher;
    String name;
    int image;

    public Items(String title, String time, String many, String money, int teacher, String name, int image) {
        this.title = title;
        this.time = time;
        this.many = many;
        this.money = money;
        this.teacher = teacher;
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMany() {
        return many;
    }

    public void setMany(String many) {
        this.many = many;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
