package com.example.recycler;

public class Games {
    private String name, status, description;
    private int image;

    public Games(String name, String status, String description, int image) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
    public int getImage(){
        return image;
    }
}
