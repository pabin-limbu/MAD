package com.example.linechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    private static final String TAG="mainActivity";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChart =findViewById(R.id.linechart);
      //  mChart.setOnChartGestureListener(this);
        //mChart.setOnChartValueSelectedListener(this);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getXAxis().setDrawGridLines(false);



        ArrayList<Entry> yValue = new ArrayList<>();
        yValue.add(new Entry(0,60f));
        yValue.add(new Entry(1,70f));
        yValue.add(new Entry(2,80f));
        yValue.add(new Entry(3,50f));


        ArrayList<Entry> xValue = new ArrayList<>();
        xValue.add(new Entry(0,-20f));
        xValue.add(new Entry(1,80f));
        xValue.add(new Entry(2,-10f));
        xValue.add(new Entry(3,100f));




        LineDataSet xAxix = new LineDataSet(yValue,"X axix");
        LineDataSet yAxix = new LineDataSet(xValue,"Y axix");
        xAxix.setFillAlpha(110);
        yAxix.setFillAlpha(110);
        xAxix.setCircleHoleRadius(30f);
        xAxix.setCircleColor(Color.GRAY);
        xAxix.setValueTextSize(15f);
        yAxix.setValueTextSize(15f);



        ArrayList<ILineDataSet> dataSet = new ArrayList<>();

        xAxix.setColor(Color.RED);
       // xAxix.setCircleHoleRadius(50f);
        dataSet.add(xAxix);
       // ArrayList<ILineDataSet> dataSet1 = new ArrayList<>();
        dataSet.add(yAxix);

        LineData data = new LineData(dataSet);
        data.setValueTextColor(Color.RED);
        mChart.setData(data);


       // mChart.setData(data1);






    }
}
