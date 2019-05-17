package com.example.homeworknavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ImageView.OnClickListener {

    ImageView image_froyo, image_iceCream, image_donut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_froyo = findViewById(R.id.img_froyo);
        image_donut = findViewById(R.id.img_donut);
        image_iceCream = findViewById(R.id.img_icecream);

        image_iceCream.setOnClickListener(this);
        image_donut.setOnClickListener(this);
        image_froyo.setOnClickListener(this);
    }


    public void goToActivity() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_donut:
                Intent intent = new Intent(this,DonutActivity.class);
                startActivity(intent);
                break;

            case R.id.img_froyo:
                Intent intent1 = new Intent(this,FroyoActivity.class);
                startActivity(intent1);
                break;
            case R.id.img_icecream:
                Intent intent2 = new Intent(this,IceCreamActivity.class);
                startActivity(intent2);
                break;

        }


    }
}

