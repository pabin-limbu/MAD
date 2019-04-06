package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText=findViewById(R.id.website_editText);
        mShareTextEditText = findViewById(R.id.share_editText);
        mLocationEditText = findViewById(R.id.location_editText);
    }

    public void openWebsite(View view) {
        //fetch web address form input field
        String url = mWebsiteEditText.getText().toString();
        //Encode and parse the string into URL object.
        Uri webpage = Uri.parse(url);
        //Create a new Intent with Intent.ACTION_VIEW as the action and the URI as the data:
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        //Use the resolveActivity() method and the Android package manager to find an Activity that can handle your implicit Intent.
        //Make sure that the request resolved successfully.
        //You use it to make sure there is at least one Activity that can handle your requests.
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);

        }else   {
            Log.d("Implicit Intent","can't handle this intent");

        }



    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();
        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        //Android provides the ShareCompat.IntentBuilder helper class to make implementing sharing easy.
        // You can use ShareCompat.IntentBuilder to build an Intent and launch a chooser to let the user choose the destination app for sharing.
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_title)
                .setText(txt)
                .startChooser();
    }
}
