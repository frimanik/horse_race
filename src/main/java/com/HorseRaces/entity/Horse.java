package com.HorseRaces.entity;

public class Horse{
    private Long id;
    private String color;

    public  Horse(Long id, String color){
        this.id = id;
        this.color=color;
    }

    public long getId(){
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getColor() {
        return color;
    }

    public void setColor(String color) { this.color = color; }
}