package com.example.asteroidsapp.data;

import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.example.asteroidsapp.data.entities.Photos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ImageOfTheDay.class, Photo.class},  version = 1, exportSchema = false)
public abstract class AsteroidsAppDB extends RoomDatabase {
    public abstract ImageOfTheDayDao imageOfTheDayDao();
    public abstract CuriosityPhotosDao curiosityPhotosDao();
}
