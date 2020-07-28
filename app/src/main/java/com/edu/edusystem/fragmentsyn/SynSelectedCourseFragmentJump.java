package com.edu.edusystem.fragmentsyn;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.edu.edusystem.R;
import com.edu.edusystem.fragmentsyn.recyclerview.Items;
import com.edu.edusystem.fragmentsyn.recyclerview.MyAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;


public class SynSelectedCourseFragmentJump extends AppCompatActivity {
    List<Items> list = new ArrayList<>();
    RecyclerView recyclerView;
    MaterialToolbar syn_Selected_course_toobar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_syn_selected_course);
        recyclerView = findViewById(R.id.syn_Selected_course_recyc);
        syn_Selected_course_toobar = findViewById(R.id.syn_Selected_course_toobar);
        final Items items1 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
        Items items2 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
        Items items3 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
        Items items4 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
        Items items5 = new Items("张雪峰高考志愿填报精品课", "购买后365天内有效", "69次课", "199",
                R.drawable.ic_baseline_person_24, "张雪峰", R.drawable.ic_baseline_favorite_border_24);
        list.add(items1);
        list.add(items2);
        list.add(items3);
        list.add(items4);
        list.add(items5);
        recyclerView.setLayoutManager(new LinearLayoutManager(SynSelectedCourseFragmentJump.this));
        recyclerView.setAdapter(new MyAdapter(this, list, new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                if (pos == 0) {
                    Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                } else if (pos == 1) {
                    Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();

                } else if (pos == 2) {
                    Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();

                } else if (pos == 3) {
                    Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "5", Toast.LENGTH_SHORT).show();

                }
            }
        }));

        syn_Selected_course_toobar = findViewById(R.id.syn_Selected_course_toobar);
        syn_Selected_course_toobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavController controller = Navigation.findNavController(SynSelectedCourseFragmentJump.this, R.id.fragment2);
//                controller.navigateUp();
                finish();
            }
        });
    }
}