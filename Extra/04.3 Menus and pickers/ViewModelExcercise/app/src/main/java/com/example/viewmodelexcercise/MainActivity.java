package com.example.viewmodelexcercise;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ViewModelProviders.of(this).get(MyViewModel.class);
    }
}
