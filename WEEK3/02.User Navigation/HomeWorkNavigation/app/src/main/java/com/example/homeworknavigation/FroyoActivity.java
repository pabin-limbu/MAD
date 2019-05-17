package com.example.homeworknavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

public class FroyoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froyo);

       android.support.v7.widget.Toolbar toolBar = findViewById(R.id.froyo_toolbar);
       setSupportActionBar(toolBar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setHomeButtonEnabled(true);
    }
}
