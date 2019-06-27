package com.example.asteroidsapp;

import android.app.Application;

import com.example.asteroidsapp.data.Repository;

public class AsteroidsApp extends Application {

    private Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(this);
    }

    public Repository getRepository() {
        return repository;
    }
}
