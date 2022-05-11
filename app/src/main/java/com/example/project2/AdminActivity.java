package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.project2.ui.main.SectionsPagerAdapter;
import com.example.project2.databinding.ActivityAdminBinding;

/**
 * AdminActivity contains whole Fragment(USERS and ITEMS)
 * tabs -> Tab(USERS / ITEMS)
 * viewPager -> view pages when the tab is USERS or ITEMS
 */

/**
 * AdminActivity > SectionPagerAdapter > Fragment |||>>> dont use anymore PlaceholderFragment > PageViewModel
 */

public class AdminActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.userIdKey";

    private ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Pass userId to Fragment
        int userId = getIntent().getIntExtra(USER_ID_KEY, 0);
        Bundle args = new Bundle();
        args.putInt("USER_ID_KEY_FROM_ADMIN_ACTIVITY", userId);

        // Defined there are two Tabs in this Activity
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), args);

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, AdminActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }
}