package com.example.dialogforalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAllertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAllertBuilder.setTitle("Alert");
        myAllertBuilder.setMessage("Click ok to continue or cancel to Stop");

        // Adding a dialogue button
      myAllertBuilder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getApplicationContext(),"pressed ok",Toast.LENGTH_SHORT).show();

          }
      });

      myAllertBuilder.setNegativeButton(R.string.cancle_button, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getApplicationContext(),"Pressed cancel",Toast.LENGTH_SHORT).show();
          }
      });

      myAllertBuilder.show();

    }


}
