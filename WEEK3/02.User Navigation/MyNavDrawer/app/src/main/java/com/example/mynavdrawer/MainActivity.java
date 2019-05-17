package com.example.mynavdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        drawer = findViewById(R.id.drawer_layouts);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TimeFragment()).commit();
            //above line of code will place our time fragment inside fragment container which is created on activity main.xml frame layout.
            navigationView.setCheckedItem(R.id.nav_time);
        }

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_time:
                getSupportFragmentManager().beginTransaction().addToBackStack("tag").replace(R.id.fragment_container, new TimeFragment()).commit();
                //above line of code will place our time fragment inside fragment container which is created on activity main.xml frame layout.
                break;
            case R.id.nav_event:
                getSupportFragmentManager().beginTransaction().addToBackStack("tag").replace(R.id.fragment_container, new EventFragment()).commit();
                //above line of code will place our event fragment inside fragment container which is created on activity main.xml frame layout.
                break;

            case R.id.nav_email:
               getSupportFragmentManager().popBackStack("tag",1);

               Toast.makeText(this, "email is selected", Toast.LENGTH_SHORT).show();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
