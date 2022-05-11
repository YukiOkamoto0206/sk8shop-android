package com.example.project2.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project2.R;
import com.example.project2.fragment.ItemsFragment;
import com.example.project2.fragment.UsersFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_users, R.string.tab_items};
    private final Context mContext;
    private Bundle mArgs;

    public SectionsPagerAdapter(Context context, FragmentManager fm, Bundle args) {
        super(fm);
        mContext = context;
        mArgs = args;
    }

    @Override
    public Fragment getItem(int position) {
        // Change the fragment
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new UsersFragment();
                fragment.setArguments(mArgs);
                break;
            case 1:
                fragment = new ItemsFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // The number of tabs
        return 2;
    }
}