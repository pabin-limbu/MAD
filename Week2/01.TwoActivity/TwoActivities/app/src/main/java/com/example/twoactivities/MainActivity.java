package com.example.twoactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE ="com.example.android.twoActivities.extra.message";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        String message =mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        //startActivity(intent);
        //when activity expected with resunl from another activity
        startActivityForResult(intent,TEXT_REQUEST);
        Log.d(LOG_TAG,"Button clicked");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //to make sure you process the right Intent result, in case there are several.
        // Also test for RESULT_OK, to make sure that the request was successful:
        //in this case first request code is to address which intent (code provided for above intent)
        //as we know that second activity ma RESULT_ok wala req pathako cha which is in int , so the result code hold that data
        //finally intent dat means the data that is sent and received here.
        Log.d(LOG_TAG,"something is received");

        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){

                String reply =data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
