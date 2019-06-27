package com.example.asteroidsapp.data;

import android.content.Context;

import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;

import java.io.IOException;

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
    /*
    TodayWeather getWeatherDay(String city, String units) {
        Call<WeatherDay> call = weatherService.getWeatherDay(city, units, this.apiKey);
        try {
            Response<WeatherDay> response = call.execute();
            if (response.isSuccessful()) {
                WeatherDay weatherDay = response.body();
                TodayWeather todayWeather = new TodayWeather();
                todayWeather.weatherCode = weatherDay.getWeather().get(0).getId();
                todayWeather.weatherCondition = weatherDay.getWeather().get(0).getMain().toUpperCase();
                todayWeather.temperature = weatherDay.getMain().getTemp();
                todayWeather.wind = weatherDay.getWind().getSpeed();
                todayWeather.pressure = (double) Math.round(weatherDay.getMain().getPressure() * 0.75);
                todayWeather.humidity = weatherDay.getMain().getHumidity();
                return todayWeather;
            }
        } catch (IOException ioex) {
            return null;
        }
        return null;
    }
    */
}