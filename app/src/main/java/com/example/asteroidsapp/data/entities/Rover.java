package com.example.asteroidsapp.data.entities;

import java.util.List;

public class Rover {
    private int id;

    private String name;

    private String landing_date;

    private String launch_date;

    private String status;

    private int max_sol;

    private String max_date;

    private int total_photos;

    private List<Cameras> cameras;

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
    public void setLanding_date(String landing_date){
        this.landing_date = landing_date;
    }
    public String getLanding_date(){
        return this.landing_date;
    }
    public void setLaunch_date(String launch_date){
        this.launch_date = launch_date;
    }
    public String getLaunch_date(){
        return this.launch_date;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setMax_sol(int max_sol){
        this.max_sol = max_sol;
    }
    public int getMax_sol(){
        return this.max_sol;
    }
    public void setMax_date(String max_date){
        this.max_date = max_date;
    }
    public String getMax_date(){
        return this.max_date;
    }
    public void setTotal_photos(int total_photos){
        this.total_photos = total_photos;
    }
    public int getTotal_photos(){
        return this.total_photos;
    }
    public void setCameras(List<Cameras> cameras){
        this.cameras = cameras;
    }
    public List<Cameras> getCameras(){
        return this.cameras;
    }
}
