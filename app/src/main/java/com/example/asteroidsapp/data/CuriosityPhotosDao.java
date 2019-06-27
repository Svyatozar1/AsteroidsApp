package com.example.asteroidsapp.data;

import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.example.asteroidsapp.data.entities.Photos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CuriosityPhotosDao {
    @Insert
    void insertCuriosityPhotos (List<Photo> curiosityPhotos);

    @Query("SELECT * FROM `curiosityPhotos`")

    List<Photo> getCuriosityPhotos();

    @Query("DELETE FROM `curiosityPhotos`")

    void deleteAll ();
}
