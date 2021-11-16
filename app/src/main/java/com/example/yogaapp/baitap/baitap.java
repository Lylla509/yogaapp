package com.example.yogaapp.baitap;

import com.example.yogaapp.Pose;

import java.util.List;

public class baitap {
    public String tenBT;
    public List<Pose> listBt;

    public baitap(String tenBT, List<Pose> listBt) {
        this.tenBT = tenBT;
        this.listBt = listBt;
    }

    public String getTenBT() {
        return tenBT;
    }

    public void setTenBT(String tenBT) {
        this.tenBT = tenBT;
    }

    public List<Pose> getListBt() {
        return listBt;
    }

    public void setListBt(List<Pose> listBt) {
        this.listBt = listBt;
    }
}
