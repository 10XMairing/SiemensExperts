package com.github.tenx.xservices.ui.Services;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServicesViewPagerAdapter extends FragmentPagerAdapter {


    private  List<Fragment> listFragment=new ArrayList<>();
    private List<String> listTitles = new ArrayList<>();

    public ServicesViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }
    public void addFragment(Fragment fragment,String title){

        listFragment.add(fragment);
        listTitles.add(title);
    }
}
