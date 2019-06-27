package com.example.asteroidsapp.data;

import com.example.asteroidsapp.data.entities.ImageOfTheDay;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ImageOfTheDayDao {
    @Insert
    void insertImageOfTheDay (ImageOfTheDay imageOfTheDay);

    @Query("SELECT * FROM `imageOfTheDay`")

    ImageOfTheDay getImageOfTheDay();

    @Query("DELETE FROM `imageOfTheDay`")

    void deleteAll ();

}
