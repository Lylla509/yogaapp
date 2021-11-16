package com.example.yogaapp.story;

public class Story {
    public int img;
    public String nameStr;

    public Story(int img, String nameStr) {
        this.img = img;
        this.nameStr = nameStr;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }
}
