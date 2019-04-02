package com.example.HelloConstraint;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private int mCount =0;
    private TextView mShowCount;
    private Button btnCountt;
    private Button btnZero;

    @BindView(R.id.btnCount) Button btnCounts;
private int resetValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=(TextView)findViewById(R.id.show_count);
       //btnCountt=(Button)btnCounts;
        btnZero=(Button)findViewById(R.id.btnZero);
       ButterKnife.bind(this);
    }

    public void showToast(View view) {
        Toast toast= Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();

    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

        if (mCount % 2 == 0) {
            btnCounts.setBackgroundColor(Color.parseColor("#00FFFF"));

        } else if (mCount % 2 != 0) {

            btnCounts.setBackgroundColor(Color.parseColor("#32CD32"));

        }
        if (mCount > 0)
            btnZero.setBackgroundColor(Color.BLUE);
    }

    public void resetCount(View view){

        mShowCount.setText(Integer.toString(resetValue));
        mCount=0;
       // btnZero.setBackgroundColor(Color.GRAY);
        view.setBackgroundColor(Color.GRAY);
    }


}
