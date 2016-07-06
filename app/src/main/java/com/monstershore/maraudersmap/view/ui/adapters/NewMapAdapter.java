package com.monstershore.maraudersmap.view.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.monstershore.maraudersmap.view.ui.fragments.SelectCityFragment;

/**
 * Created by Gustavo on 6/29/16.
 */

public class NewMapAdapter extends FragmentPagerAdapter {

    public NewMapAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = SelectCityFragment.newInstance();
                break;
            default:
                fragment = SelectCityFragment.newInstance();
                break;
        }
        return fragment;
    }

}
