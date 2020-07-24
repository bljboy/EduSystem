package com.edu.edusystem.fragmentAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.edu.edusystem.R;

import java.util.ArrayList;

/**
 * 这里的代码不要动哦
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragList;
    private String[] titles = {"综合","课程"};

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragList) {
        super(fm);
        this.fragList = fragList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
