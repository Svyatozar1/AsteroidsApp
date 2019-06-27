package com.example.asteroidsapp.data.entities;

public class Photos {
    private int id;

    private int sol;

    private Camera camera;

    private String img_src;

    private String earth_date;

    private Rover rover;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setSol(int sol){
        this.sol = sol;
    }
    public int getSol(){
        return this.sol;
    }
    public void setCamera(Camera camera){
        this.camera = camera;
    }
    public Camera getCamera(){
        return this.camera;
    }
    public void setImg_src(String img_src){
        this.img_src = img_src;
    }
    public String getImg_src(){
        return this.img_src;
    }
    public void setEarth_date(String earth_date){
        this.earth_date = earth_date;
    }
    public String getEarth_date(){
        return this.earth_date;
    }
    public void setRover(Rover rover){
        this.rover = rover;
    }
    public Rover getRover(){
        return this.rover;
    }
}
