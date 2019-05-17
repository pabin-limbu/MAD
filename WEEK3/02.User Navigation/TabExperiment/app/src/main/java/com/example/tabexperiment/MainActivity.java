package com.example.tabexperiment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ... Code inside onCreate() method
        android.support.v7.widget.Toolbar toolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create an instance of the tab layout from the view.


        TabLayout tablayout = findViewById(R.id.tab_layout);
        //text for each tab layout
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label1));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label2));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label3));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tablayout.getTabCount());

        //set pagerAdapter to viewPager so that viewPager can use the adapter to get the fragment and count
        viewPager.setAdapter(adapter);

        // Setting a listener for swap/ changing pages.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        //listener for tabClicks
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //view pager set the current item which is pages
            viewPager.setCurrentItem(tab.getPosition());
                Log.d("Tab num"," "+tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
