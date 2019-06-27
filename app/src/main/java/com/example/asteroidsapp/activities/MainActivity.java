package com.example.asteroidsapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.asteroidsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onImageDayBtnClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ImageDayActivity.class);
        startActivity(intent);
    }
    public void onAsteroidsListClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), AsteroidsListActivity.class);
        startActivity(intent);
    }
}
