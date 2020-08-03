package com.edu.edusystem.fragmentsyn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.edu.edusystem.R;
import com.edu.edusystem.fragmentsyn.recyclerview.Items;
import com.edu.edusystem.fragmentsyn.recyclerview.MyAdapter;
import com.edu.edusystem.tools.DBHelper;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SynSelectedCourseFragmentJump extends AppCompatActivity {
    private static final String TAG = "SynSelectedCourseFragmentJump";
    List<Items> list = new ArrayList<>();
    RecyclerView recyclerView;
    MaterialToolbar syn_Selected_course_toobar;
    String jsonMysql = ""; // 云端的json数据
    SharedPreferences sp;
    String user;
    String sql;
    Object[] objects;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syn_home_select_recyc);
        recyclerView = findViewById(R.id.syn_Selected_course_recyc);




        new Thread() {
            @Override
            public void run() {
                sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                final String type = sp.getString("type","");
                if(type.equals("1")){
                    user = sp.getString("user","");
                    sql = "select favorite_course from user_table where phone=?";
                    objects = new Object[]{user};
                }else if(type.equals("2")){
                    user = sp.getString("openId","");
                    sql = "select favorite_course from user_table where qq_openid=?";
                    objects = new Object[]{user};
                }


                List<HashMap<String, Object>> dataList = DBHelper.getList(sql, objects);
                for (HashMap<String, Object> map : dataList) {

                    jsonMysql = (String) map.get("favorite_course");

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        final Items items1 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
                        final Items items2 = new Items("2021高考化学全程班", "2020.02.29 — 2021.06.10", "74次课", "6280",
                                R.drawable.ic_baseline_person_24, "李郑", R.drawable.ic_baseline_favorite_border_24);
                        final Items items3 = new Items("2021高考语文全程班", "2020.02.29 — 2021.06.10", "70次课", "6280",
                                R.drawable.ic_baseline_person_24, "陈焕文", R.drawable.ic_baseline_favorite_border_24);
                        final Items items4 = new Items("2021高考数学全程班", "2020.02.29 — 2021.06.10", "80次课", "6280",
                                R.drawable.ic_baseline_person_24, "王嘉庆", R.drawable.ic_baseline_favorite_border_24);
                        final Items items5 = new Items("2021高考生物全程班", "2020.02.29 — 2021.06.10", "80次课", "6280",
                                R.drawable.ic_baseline_person_24, "任春磊", R.drawable.ic_baseline_favorite_border_24);
                        list.add(items1);
                        list.add(items2);
                        list.add(items3);
                        list.add(items4);
                        list.add(items5);

                        recyclerView.setLayoutManager(new LinearLayoutManager(SynSelectedCourseFragmentJump.this));
                        recyclerView.setAdapter(new MyAdapter(SynSelectedCourseFragmentJump.this, list, new MyAdapter.OnItemClickListener() {
                            @Override
                            public void onClick(int pos) {
                                //Toast.makeText(getApplicationContext(), "" + pos, Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onItemClick(View v) {
                            }
                        }, jsonMysql,type,user));

                        Log.i("XXXXXXXXXXXX", "XXXXXXXXXXXXXXX");
                    }
                });

                Log.i("XXXXXXXXXXXX", "XXXXXXXXXXXXXXX2222");

            }
        }.start();


        syn_Selected_course_toobar = findViewById(R.id.syn_Selected_course_toolbar);
//        syn_Selected_course_toobar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                NavController controller = Navigation.findNavController(SynSelectedCourseFragmentJump.this, R.id.fragment2);
////                controller.navigateUp();
//            }
//        });
        syn_Selected_course_toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}