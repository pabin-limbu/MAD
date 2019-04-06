package com.example.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter=0;
    private TextView text_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_count = findViewById(R.id.txt_counter);

        if (savedInstanceState!=null){

            text_count.setText(savedInstanceState.getString(Integer.toString(R.id.txt_counter)));
        }
    }

    public void incrementCounter(View view) {
        counter++;
        text_count.setText(Integer.toString(counter));


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString( Integer.toString(R.id.txt_counter),((TextView)findViewById(R.id.txt_counter)).getText().toString());


    }
}
