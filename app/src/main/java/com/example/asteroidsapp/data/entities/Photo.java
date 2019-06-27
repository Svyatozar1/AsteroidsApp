package com.example.asteroidsapp.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "curiosityPhotos")
public class Photo {
    @PrimaryKey
    public int id;

    public int sol;

    public String img_src;

    public String earth_date;
}
