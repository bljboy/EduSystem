package com.edu.edusystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.edu.edusystem.fragmentAdapter.FragmentAdapter;
import com.edu.edusystem.fragmentThree.FragmentHomePage;
import com.edu.edusystem.fragmentThree.FragmentMe;
import com.edu.edusystem.fragmentThree.FragmentStudy;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * 这里的代码不要动哦
 */

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentAdapter fragmentAdapter;
    private BottomNavigationView bottomNavigationView;
    //ViewPager viewPager;
    private int lastIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_bottomNavigationView);
        initData();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_homepage:
                        setFragmentPosition(0);
                        break;
                    case R.id.menu_study:
                        setFragmentPosition(1);
                        break;
                    case R.id.menu_me:
                        setFragmentPosition(2);
                        break;

                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }


    public void initData() {
        list.add(new FragmentHomePage());
        list.add(new FragmentStudy());
        list.add(new FragmentMe());
        // 初始化展示
        setFragmentPosition(0);
    }

    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = list.get(position);
        Fragment lastFragment = list.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.host_layout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}