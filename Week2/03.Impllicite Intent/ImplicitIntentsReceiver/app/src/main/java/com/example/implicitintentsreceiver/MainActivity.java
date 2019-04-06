package com.example.implicitintentsreceiver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri = intent.getData();

        if (uri!=null){
            String uri_string = getString(R.string.uri_label)+uri.toString();
            TextView textView = findViewById(R.id.text_uri_message);
            textView.setText(uri_string);
        }
    }
}
//Implicit intent receive garnu lai
// menifest ma gayera intent filter mah action category and data tag halnu parcha.
//action tag defines what type of intent
// category defines which category of request to receive
//data is an actual data used by another activity like url used in another activity.