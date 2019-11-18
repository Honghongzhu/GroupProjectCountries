package com.example.groupprojectcountries.Play;

public class Region {
    private String name;
    private String imageUrl;

    public Region(String name, String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
