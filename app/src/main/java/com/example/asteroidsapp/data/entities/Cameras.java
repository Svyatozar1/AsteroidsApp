package com.example.asteroidsapp.data.entities;

public class Cameras {
    private String name;

    private String full_name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setFull_name(String full_name){
        this.full_name = full_name;
    }
    public String getFull_name(){
        return this.full_name;
    }
}
