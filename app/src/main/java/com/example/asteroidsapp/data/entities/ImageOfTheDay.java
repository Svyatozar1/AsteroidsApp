package com.example.asteroidsapp.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "imageOfTheDay")
public class ImageOfTheDay
{
    public String copyright;

    public String date;

    public String explanation;

    public String hdurl;

    public String media_type;

    public String service_version;

    public String title;

    @NonNull
    @PrimaryKey
    public String url;
}
