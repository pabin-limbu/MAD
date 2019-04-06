package com.example.threepassage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PassageViewActivity extends AppCompatActivity {

    private TextView headingView;
    private  TextView contendView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passage_view);

        Intent intent=getIntent();
        String command=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        headingView=findViewById(R.id.txt_heading);
        headingView.setText(command);
        contendView=findViewById(R.id.txt_passage);
        viewPassage(command);


    }

    protected void viewPassage(String commands){
        if (commands.equals("Animal")){
            contendView.setText(R.string.txt_animal);

        }else if (commands.equals("Bird")){
            contendView.setText(R.string.txt_bird);


        }else if (commands.equals("Fish")){
            contendView.setText(R.string.txt_fish);


        }




    }
}
