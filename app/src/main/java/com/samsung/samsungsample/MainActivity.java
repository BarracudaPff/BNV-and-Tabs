package com.samsung.samsungsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.samsung.samsungsample.adapters.MyFragmentPagerAdapter;
import com.samsung.samsungsample.fragments.HomeFragment;
import com.samsung.samsungsample.fragments.LocationFragment;
import com.samsung.samsungsample.fragments.ProfileFragment;
import com.samsung.samsungsample.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: replace `R.layout.activity_main_tab` with `R.layout.activity_main` and use `MainActivityBNV`
        setContentView(R.layout.activity_main_tab);

        initViews();

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(this);

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Home");
                        break;
                    case 1:
                        tab.setText("Profile");
                        break;
                    case 2:
                        tab.setText("Settings");
                        break;
                }
            }
        }).attach();
    }

    void initViews() {
        navigationView = findViewById(R.id.bottomNavigationView);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
    }
}