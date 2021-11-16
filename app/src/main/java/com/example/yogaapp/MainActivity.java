package com.example.yogaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.yogaapp.fragment.CalendarFragment;
import com.example.yogaapp.fragment.HomeFragment;
import com.example.yogaapp.fragment.InforFragment;
import com.example.yogaapp.fragment.NetworkFragment;
import com.example.yogaapp.fragment.ProcessFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.homeFragment:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.processFragment:
                    selectedFragment= new ProcessFragment();
                    break;
                case R.id.networkFragment:
                    selectedFragment = new NetworkFragment();
                    break;
                case R.id.calendarFragment:
                    selectedFragment = new CalendarFragment();
                    break;
                case R.id.inforFragment:
                    selectedFragment = new InforFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();
            return true;
        }
    };



}