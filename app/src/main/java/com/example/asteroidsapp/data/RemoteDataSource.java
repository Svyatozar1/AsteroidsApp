package com.example.asteroidsapp.data;

import android.content.Context;

import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.example.asteroidsapp.data.entities.Photos;
import com.example.asteroidsapp.data.entities.Root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RemoteDataSource {
    private NasaService nasaService;
    private String apiKey;

    public RemoteDataSource(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        nasaService = retrofit.create(NasaService.class);
        apiKey = context.getString(R.string.api_key);
    }
    public boolean checkInternetConnection () {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }
    ImageOfTheDay getImageOfTheDay () {
        Call<ImageOfTheDay> call = nasaService.getImageOfTheDay(this.apiKey);
        try {
            Response<ImageOfTheDay> response = call.execute();
            if (response.isSuccessful()) {
                ImageOfTheDay imageOfTheDay = response.body();
                return imageOfTheDay;
            }
        } catch (IOException ioex) {
            return null;
        }
        return null;
    }
    List<Photo> getCuriosityPhotos () {
        Call<Root> call = nasaService.getCuriosityPhotos(1000, this.apiKey);
        try {
            Response<Root> response = call.execute();
            if (response.isSuccessful()) {
                Root curiosityPhotos = response.body();
                List<Photos> photosList = curiosityPhotos.getPhotos();
                ArrayList<Photo> photoList = new ArrayList<Photo>();
                for (Photos i : photosList) {
                    Photo p = new Photo();
                    p.id = i.getId();
                    p.earth_date = i.getEarth_date();
                    p.img_src = i.getImg_src();
                    p.sol = i.getSol();
                    photoList.add(p);
                }
                return photoList;
            }
        } catch (IOException ioex) {
            return null;
        }
        return null;
    }
}