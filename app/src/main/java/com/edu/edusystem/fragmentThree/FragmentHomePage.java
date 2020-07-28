package com.edu.edusystem.fragmentThree;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.edusystem.R;
import com.edu.edusystem.fragmentAdapter.FragmentAdapter;
import com.edu.edusystem.fragmenthomepage.FragmentClass;
import com.edu.edusystem.fragmenthomepage.FragmentSyn;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/***
 * -----首页------
 * -----功能：-------
 * 精选课程、名师讲解、答疑专区、艺考、语文、数学、英语、物理、化学、生物、历史、政治、地理。。。。。
 */

public class FragmentHomePage extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<Fragment> list;
    FragmentAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.syn_home_viewpager, container, false);
    }

    //功能实现操作
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = getActivity().findViewById(R.id.homepage_tabLayout);
        viewPager = getActivity().findViewById(R.id.homepage_viewpager);
        list = new ArrayList<>();
        list.add(new FragmentSyn());
        list.add(new FragmentClass());
        adapter = new FragmentAdapter(getChildFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}