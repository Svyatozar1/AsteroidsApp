package com.example.asteroidsapp.data;

import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {
    @GET("/planetary/apod")
    Call<ImageOfTheDay> getImageOfTheDay(@Query("api_key") String apiKey);

    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    Call<Root> getCuriosityPhotos(@Query("sol") Integer sol, @Query("api_key") String apiKey);
}
