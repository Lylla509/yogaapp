package com.example.yogaapp;

public class Pose {
    public int imgPose;
    public String namePose;

    public Pose(int imgPose, String namePose) {
        this.imgPose = imgPose;
        this.namePose = namePose;
    }

    public int getImgPose() {
        return imgPose;
    }

    public void setImgPose(int imgPose) {
        this.imgPose = imgPose;
    }

    public String getNamePose() {
        return namePose;
    }

    public void setNamePose(String namePose) {
        this.namePose = namePose;
    }
}
