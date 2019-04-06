package com.example.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int message= intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0);
        TextView countView= findViewById(R.id.txt_counter_view);
        countView.setText(""+message);
    }
}
