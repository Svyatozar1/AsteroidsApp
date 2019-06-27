package com.example.asteroidsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.asteroidsapp.AsteroidsApp;
import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.ImageOfTheDayDao;
import com.example.asteroidsapp.data.Repository;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;

public class ImageDayActivity extends AppCompatActivity implements Observer<ImageOfTheDay> {
    private Repository repository;
    private MutableLiveData<ImageOfTheDay> imageOfTheDayLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_day);
        repository = ((AsteroidsApp)getApplication()).getRepository();
        ActionBar actionBar = getSupportActionBar();
        try {
            actionBar.setTitle(getString(R.string.image_of_the_day));
            actionBar.setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {};
        imageOfTheDayLiveData = repository.getImageOftheDay();
        imageOfTheDayLiveData.observe(this, this);

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
    public void onChanged(ImageOfTheDay imageOfTheDay) {
        if (imageOfTheDay != null) {
            Toast.makeText(this, imageOfTheDay.copyright, Toast.LENGTH_SHORT).show();
        }
    }
}
