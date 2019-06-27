package com.example.asteroidsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asteroidsapp.AsteroidsApp;
import com.example.asteroidsapp.R;
import com.example.asteroidsapp.adapters.CuriosityPhotosListAdapter;
import com.example.asteroidsapp.data.Repository;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.example.asteroidsapp.data.entities.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AsteroidsListActivity extends AppCompatActivity implements Observer<List<Photo>> {
    private SharedPreferences sPref;
    private Repository repository;
    private MutableLiveData<List<Photo>> curiosityPhotosLiveData;
    private EditText inputDate;
    private RecyclerView recyclerView;
    private CuriosityPhotosListAdapter curiosityPhotosListAdapter;
    private String lastInput = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids_list);
        sPref = getSharedPreferences("nasa_app", MODE_PRIVATE);
        repository = ((AsteroidsApp)getApplication()).getRepository();
        lastInput = "";

        ActionBar actionBar = getSupportActionBar();
        try {
            actionBar.setTitle(getString(R.string.near_asteroids_list));
            actionBar.setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {}

        inputDate = findViewById(R.id.inputDate);
        recyclerView = findViewById(R.id.curiosityPhotosList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        curiosityPhotosListAdapter = new CuriosityPhotosListAdapter(new ArrayList<Photo>(),
                this);
        recyclerView.setAdapter(curiosityPhotosListAdapter);

        String lastDate = sPref.getString("query", "");
        if (lastDate.length() > 0) {
            curiosityPhotosLiveData = repository.getCuriosityPhotos(lastDate);
            curiosityPhotosLiveData.observe(this, this);
        }
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
            if (lastInput.length() > 0) {
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString("query", lastInput);
                ed.apply();
            }
            if (curiosityPhotos.size() == 0) {
                Toast.makeText(this, "No results", Toast.LENGTH_SHORT).show();
            }
            curiosityPhotosListAdapter.changeData((ArrayList<Photo>)curiosityPhotos);
        }
    }
    public void updatePhotosList(View view) {
        String date = inputDate.getText().toString();
        lastInput = date;
        if (curiosityPhotosLiveData != null) {
            curiosityPhotosLiveData.removeObserver(this);
        }
        curiosityPhotosLiveData = repository.getCuriosityPhotos(date);
        curiosityPhotosLiveData.observe(this, this);
    }
}
