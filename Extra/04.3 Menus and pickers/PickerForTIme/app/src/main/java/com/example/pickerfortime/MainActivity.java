package com.example.pickerfortime;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");

    }

    public void processTimePickerResult(int hour,int minute){
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String time_message = (getString(R.string.hour)+hour_string+getString(R.string.minute)+minute_string);
        Toast.makeText(this,time_message,Toast.LENGTH_SHORT ).show();





    }


}
