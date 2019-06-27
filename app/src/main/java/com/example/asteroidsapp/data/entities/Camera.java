package com.example.asteroidsapp.data.entities;

public class Camera {
    private int id;

    private String name;

    private int rover_id;

    private String full_name;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setRover_id(int rover_id){
        this.rover_id = rover_id;
    }
    public int getRover_id(){
        return this.rover_id;
    }
    public void setFull_name(String full_name){
        this.full_name = full_name;
    }
    public String getFull_name(){
        return this.full_name;
    }
}
