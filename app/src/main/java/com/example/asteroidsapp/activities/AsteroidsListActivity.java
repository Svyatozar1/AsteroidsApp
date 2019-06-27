package com.example.asteroidsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.asteroidsapp.AsteroidsApp;
import com.example.asteroidsapp.R;
import com.example.asteroidsapp.adapters.CuriosityPhotosListAdapter;
import com.example.asteroidsapp.data.Repository;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AsteroidsListActivity extends AppCompatActivity implements Observer<List<Photo>> {
    private Repository repository;
    private MutableLiveData<List<Photo>> curiosityPhotosLiveData;
    private RecyclerView recyclerView;
    private CuriosityPhotosListAdapter curiosityPhotosListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids_list);
        repository = ((AsteroidsApp)getApplication()).getRepository();


        ActionBar actionBar = getSupportActionBar();
        try {
            actionBar.setTitle(getString(R.string.near_asteroids_list));
            actionBar.setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {}

        recyclerView = findViewById(R.id.curiosityPhotosList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        curiosityPhotosListAdapter = new CuriosityPhotosListAdapter(new ArrayList<Photo>(),
                this);
        recyclerView.setAdapter(curiosityPhotosListAdapter);

        curiosityPhotosLiveData = repository.getCuriosityPhotos();
        curiosityPhotosLiveData.observe(this, this);
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
    @Override
    public void onChanged(List<Photo> curiosityPhotos) {
        if (curiosityPhotos != null) {

        }
    }
}
