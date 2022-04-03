package com.samsung.samsungsample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.samsungsample.fragments.HomeFragment;
import com.samsung.samsungsample.fragments.LocationFragment;
import com.samsung.samsungsample.fragments.ProfileFragment;
import com.samsung.samsungsample.fragments.SettingsFragment;

public class MainActivityBNV extends AppCompatActivity {
    BottomNavigationView navigationView;

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    LocationFragment locationFragment = new LocationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        openFragment(homeFragment);
                        return true;
                    case R.id.nav_profile:
                        openFragment(profileFragment);
                        return true;
                    case R.id.nav_settings:
                        openFragment(settingsFragment);
                        return true;
                    case R.id.nav_location:
                        openFragment(locationFragment);
                        return true;
                }
                return false;
            }
        });
        openFragment(homeFragment);
    }

    void initViews() {
        navigationView = findViewById(R.id.bottomNavigationView);
    }

    void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}