package com.example.shopinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static final int TEXT_REQUEST=1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    ConstraintLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout= findViewById(R.id.layout);

        if (savedInstanceState!=null){
         //   ((TextView)findViewById(R.id.txt_1)).setText(savedInstanceState.getString(Integer.toString(R.id.txt_1)));
        }

    }

    public void launchItemListActivity(View view) {
        Intent intent = new Intent(this,ItemListActivity.class);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                String reply = data.getStringExtra(ItemListActivity.EXTRA_REPLY);

                Log.d(LOG_TAG,""+reply);

                for (int i = 0; i < layout.getChildCount(); i++) {
                    View v = layout.getChildAt(i);
                    if (v instanceof TextView) {
                        TextView tv = (TextView) v;
                        Log.d(LOG_TAG,"TV");
                        if (tv.getText().length() == 0){
                            Log.d(LOG_TAG,"TV__");
                            ((TextView) v).setText(reply);
                            break;
                        }
                    }
                }

                //if statement chalaune until 10
                // each case lai check garney
                //harek case ma harek view ko empty cha ke chaina bhanera state check garne
                // if empty then populate if not move to another case

            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Integer.toString(R.id.txt_1), ((TextView)findViewById(R.id.txt_1)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_2), ((TextView)findViewById(R.id.txt_2)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_3), ((TextView)findViewById(R.id.txt_3)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_4), ((TextView)findViewById(R.id.txt_4)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_5), ((TextView)findViewById(R.id.txt_5)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_6), ((TextView)findViewById(R.id.txt_6)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_7), ((TextView)findViewById(R.id.txt_7)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_8), ((TextView)findViewById(R.id.txt_8)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_9), ((TextView)findViewById(R.id.txt_9)).getText().toString());
        outState.putString(Integer.toString(R.id.txt_10), ((TextView)findViewById(R.id.txt_10)).getText().toString());

    }
}
