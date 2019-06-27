package com.example.asteroidsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.asteroidsapp.AsteroidsApp;
import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.Repository;

public class AsteroidsListActivity extends AppCompatActivity {
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids_list);
        repository = ((AsteroidsApp)getApplication()).getRepository();


        ActionBar actionBar = getSupportActionBar();
        try {
            actionBar.setTitle(getString(R.string.near_asteroids_list));
            actionBar.setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {};

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
