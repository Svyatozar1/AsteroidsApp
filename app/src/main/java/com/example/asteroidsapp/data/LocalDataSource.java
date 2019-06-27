package com.example.asteroidsapp.data;

import android.content.Context;

import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.example.asteroidsapp.data.entities.Photos;

import java.util.List;

import androidx.room.Room;

class LocalDataSource {
    private final AsteroidsAppDB asteroidsAppDB;
    LocalDataSource(Context context) {
        asteroidsAppDB =
                Room.databaseBuilder(context, AsteroidsAppDB.class, "asteroidsappdb").build();
    }
    void storeImageOfTheDay (ImageOfTheDay imageOfTheDay) {
        asteroidsAppDB.imageOfTheDayDao().deleteAll();
        asteroidsAppDB.imageOfTheDayDao().insertImageOfTheDay(imageOfTheDay);
    }
    ImageOfTheDay getImageOfTheDay () {
        return asteroidsAppDB.imageOfTheDayDao().getImageOfTheDay();
    }
    void storeCuriosityPhotos (List<Photo> curiosityPhotos) {
        asteroidsAppDB.curiosityPhotosDao().deleteAll();
        asteroidsAppDB.curiosityPhotosDao().insertCuriosityPhotos(curiosityPhotos);
    }
    List<Photo> getCuriosityPhotos () {
        return asteroidsAppDB.curiosityPhotosDao().getCuriosityPhotos();
    }
}