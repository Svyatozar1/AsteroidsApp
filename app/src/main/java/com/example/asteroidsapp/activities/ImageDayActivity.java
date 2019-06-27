package com.example.asteroidsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asteroidsapp.AsteroidsApp;
import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.ImageOfTheDayDao;
import com.example.asteroidsapp.data.Repository;
import com.example.asteroidsapp.data.entities.ImageOfTheDay;
import com.squareup.picasso.Picasso;

public class ImageDayActivity extends AppCompatActivity implements Observer<ImageOfTheDay> {
    private Repository repository;
    private MutableLiveData<ImageOfTheDay> imageOfTheDayLiveData;
    private TextView imageOfTheDayTitleView;
    private TextView imageOfTheDayCopyrightView;
    private TextView imageOfTheDayDescrptionView;
    private AppCompatImageView imageOfTheDayView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_day);
        imageOfTheDayView = findViewById(R.id.imageOfTheDay);
        imageOfTheDayTitleView = findViewById(R.id.imageOfTheDayTitle);
        imageOfTheDayCopyrightView = findViewById(R.id.imageCopyright);
        imageOfTheDayDescrptionView = findViewById(R.id.imageOfTheDayDescription);
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
            Picasso.with(this)
                    .load(imageOfTheDay.url)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder_error)
                    .into(imageOfTheDayView);
            imageOfTheDayTitleView.setText(imageOfTheDay.title);
            imageOfTheDayCopyrightView.setText("© " + imageOfTheDay.copyright);
            imageOfTheDayDescrptionView.setText(imageOfTheDay.explanation);
        }
    }
}
