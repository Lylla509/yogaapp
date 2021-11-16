package com.example.yogaapp;

public class Tht {
    public String id;
    public String name;


    public Tht(){
    }

    public Tht(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
