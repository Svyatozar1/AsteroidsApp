package com.example.asteroidsapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.asteroidsapp.activities.ImageDayActivity;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;

import java.util.List;
import java.util.concurrent.Executors;

import androidx.lifecycle.MutableLiveData;

import static android.content.Context.MODE_PRIVATE;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    private final SharedPreferences sPref;

    public Repository(Context context) {
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource(context);
        sPref = context.getSharedPreferences("asteroids", MODE_PRIVATE);
    }
    public MutableLiveData<ImageOfTheDay> getImageOftheDay() {
        final MutableLiveData<ImageOfTheDay> imageOfTheDayLiveData = new MutableLiveData<>();

        if (!remoteDataSource.checkInternetConnection()) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    ImageOfTheDay imageOfTheDay = localDataSource.getImageOfTheDay();
                    imageOfTheDayLiveData.postValue(imageOfTheDay);
                }
            });
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ImageOfTheDay imageOfTheDay = remoteDataSource.getImageOfTheDay();
                if (imageOfTheDay != null) {
                    imageOfTheDayLiveData.postValue(imageOfTheDay);
                    localDataSource.storeImageOfTheDay(imageOfTheDay);
                }
            }
        });
        return imageOfTheDayLiveData;
    }
    public MutableLiveData<List<Photo>> getCuriosityPhotos() {
        final MutableLiveData<List<Photo>> curiosityPhotosLiveData = new MutableLiveData<>();

        if (!remoteDataSource.checkInternetConnection()) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    List<Photo> curiosityPhotos = localDataSource.getCuriosityPhotos();
                    curiosityPhotosLiveData.postValue(curiosityPhotos);
                }
            });
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<Photo> curiosityPhotos = remoteDataSource.getCuriosityPhotos();
                if (curiosityPhotos != null) {
                    curiosityPhotosLiveData.postValue(curiosityPhotos);
                    localDataSource.storeCuriosityPhotos(curiosityPhotos);
                }
            }
        });
        return curiosityPhotosLiveData;
    }
}
