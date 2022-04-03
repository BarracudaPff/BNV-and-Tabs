package com.samsung.samsungsample.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.samsung.samsungsample.fragments.HomeFragment;
import com.samsung.samsungsample.fragments.ProfileFragment;
import com.samsung.samsungsample.fragments.SettingsFragment;

public class MyFragmentPagerAdapter extends FragmentStateAdapter {
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    public MyFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return homeFragment;
            case 1:
                return profileFragment;
            case 2:
                return settingsFragment;
            default:
                throw new IllegalArgumentException("Unknown position");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
