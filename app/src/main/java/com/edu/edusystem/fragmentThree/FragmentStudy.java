package com.edu.edusystem.fragmentThree;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.edu.edusystem.R;
import com.edu.edusystem.fragment_study.stu_community;
import com.edu.edusystem.fragment_study.stu_course;
import com.edu.edusystem.fragment_study.stu_data;
import com.edu.edusystem.fragment_study.stu_knowledgepoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * ---------学习----------
 * ---------功能：---------
 * 答疑社区、选课功能、语文必备知识点
 */
public class FragmentStudy extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

    //功能实现操作

    ListView lv;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textView = getActivity().findViewById(R.id.te);
//        textView.setText("sssssssssssssssss");

        lv=getActivity().findViewById(R.id.stu_home);

        //数据源
        String[] stu_home_icon= stu_data.stu_home_icon;//图标，显示在item
        String[] stu_home_title= stu_data.stu_home_title;//图标，显示在item
        String[] stu_home_intro= stu_data.stu_home_intro;//图标，显示在item
        List<Map<String, Object>> stu_home_listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < stu_home_icon.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("stu_home_icon", stu_home_icon[i]);
            showitem.put("stu_home_title", stu_home_title[i]);
            showitem.put("stu_home_intro", stu_home_intro[i]);
            stu_home_listitem.add(showitem);
        }
        //适配器
        SimpleAdapter stu_home_simpleAdapter=new SimpleAdapter(getContext(),//listview所在页面
                stu_home_listitem,//数据源
                R.layout.stu_home_item,//item布局
                new String[]{"stu_home_icon","stu_home_title","stu_home_intro"},//list对应的键名
                new int[]{R.id.stu_home_icon,R.id.stu_home_title,R.id.stu_home_intro});//item布局控件id
        lv.setAdapter(stu_home_simpleAdapter);//绑定适配器

        //item单击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent intent=new Intent(getContext(), SynSelectedCourseFragmentJump.class);
                    startActivity(intent);
                }
                if (i==1){
                    Intent intent=new Intent(getContext(), stu_community.class);
                    startActivity(intent);
                }
                if (i==2){
                    Intent intent=new Intent(getContext(), stu_knowledgepoint.class);
                    startActivity(intent);
                }
            }
        });


    }
}