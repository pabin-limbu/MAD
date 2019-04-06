package com.example.twoactivities;

import android.content.Intent;
import android.os.PersistableBundle;
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

        //check to make sure the save instance is not null
        if (savedInstanceState!=null){
           //if not null fetch boolean state in isVisible variable from save instance with is key which in this case is reply_visible.
          //  Log.d(LOG_TAG,"instance not null"+savedInstanceState.getString("reply_text"));
          //  Log.d(LOG_TAG,"instance not null"+savedInstanceState.getBoolean("reply_visible"));
            boolean isVisible=savedInstanceState.getBoolean("reply_visible");
            if (isVisible){
               // Log.d(LOG_TAG,"hello i am visible");
                //if the isVisible variable has true then set the visiblity of view header
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                //also fetch the text which is saved in bundle and populate it in text view.
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                //also set the visiblity for reply text view which is set invisible before
                mReplyTextView.setVisibility(View.VISIBLE);


                }

        }else  {

            Log.d(LOG_TAG,"instance ull");
        }
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
    }
/*    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //check if the reply header in this activity is visible
        //if visible save its state in bundle with key and value
        //key being the name and value being the state
        if (mReplyHeadTextView.getVisibility()==View.VISIBLE){
            //outState is the reference name for the bundle
            outState.putBoolean("reply_visible",true);
            //save the replied message as it keeps on changing as header is always the same in this case.
            outState.putString("reply_text",mReplyTextView.getText().toString());

        }
    }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //check if the reply header in this activity is visible
        //if visible save its state in bundle with key and value
        //key being the name and value being the state
        if (mReplyHeadTextView.getVisibility()==View.VISIBLE){
            //outState is the reference name for the bundle
            outState.putBoolean("reply_visible",true);
            //save the replied message as it keeps on changing as header is always the same in this case.
            outState.putString("reply_text",mReplyTextView.getText().toString());

        }

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

//save instance of activity


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
