package com.example.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    public static final String EXTRA_REPLY="com.example.android.twoactivities.extra.reply";
    private EditText mReply;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //fetch Intent which comes with the intent data
        Intent intent = getIntent();
        //storing in tent message into a string.
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //reference textView with text message element present in activity
        TextView textView=findViewById(R.id.text_message);
        //display received message in textView
        textView.setText(message);


        //returning message to main activity using intent
        mReply=findViewById(R.id.editText_second);

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"OnStart");


    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG,"onPause");


    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");


    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");


    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"oonStop");


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");


    }





    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
      //  Log.d(LOG_TAG,"soemthing"+reply);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();;


    }
}
