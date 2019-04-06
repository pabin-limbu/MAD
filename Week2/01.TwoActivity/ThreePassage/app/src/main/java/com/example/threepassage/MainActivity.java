package com.example.threepassage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE="com.example.android.threePassage.extra.message.animal";
   // public static final String EXTRA_MESSAGE_BIRD="com.example.android.threePassage.extra.message.bird";
   // public static final String EXTRA_MESSAGE_FISH="com.example.android.threePassage.extra.message.fish";
    private String command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPassageAnimal(View view) {
        Intent intent = new Intent(this,PassageViewActivity.class);
        command=((Button)view).getText().toString();
        intent.putExtra(EXTRA_MESSAGE,command);
        startActivity(intent);
    }

    public void openPassageBird(View view) {
        Intent intent = new Intent(this,PassageViewActivity.class);
        command=((Button)view).getText().toString();
        intent.putExtra(EXTRA_MESSAGE,command);
        startActivity(intent);
    }

    public void openPassageFish(View view) {
        Intent intent = new Intent(this,PassageViewActivity.class);
        command=((Button)view).getText().toString();
        intent.putExtra(EXTRA_MESSAGE,command);
        startActivity(intent);
    }
}
