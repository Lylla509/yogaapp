package com.example.yogaapp.story;

import android.widget.Button;
import android.widget.ImageView;

import com.example.yogaapp.story.Story;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<Story> stories;


    public Category(String nameCategory, List<Story> stories) {
        this.nameCategory = nameCategory;
        this.stories = stories;

    }


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }


}
