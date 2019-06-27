package com.example.asteroidsapp.data.entities;

import java.util.List;

public class Root {
    private List<Photos> photos;

    public void setPhotos(List<Photos> photos){
        this.photos = photos;
    }
    public List<Photos> getPhotos(){
        return this.photos;
    }
}
