package com.edu.edusystem.fragmentThree;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.edu.edusystem.R;
import com.edu.edusystem.fragment_study.stu_MainActivity;
import com.edu.edusystem.fragment_study.stu_data;
import com.edu.edusystem.fragment_study.stu_knowlesgepoint_more;
import com.edu.edusystem.fragment_study.stu_knowlesgepoint_particulars;

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

    ListView stu_MyCurriculum_list,stu_MentoringCommunity_list,stu_Knowledgepoint_list;
    TextView stu_MyCurriculum_more,stu_MentoringCommunity_more,stu_Knowledgepoint_more;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textView = getActivity().findViewById(R.id.te);
//        textView.setText("sssssssssssssssss");

        //listview
        stu_MyCurriculum_list=getActivity().findViewById(R.id.stu_MyCurriculum_list);//我的课程
        stu_MentoringCommunity_list=getActivity().findViewById(R.id.stu_MentoringCommunity_list);//答疑社区
        stu_Knowledgepoint_list=getActivity().findViewById(R.id.stu_Knowledgepoint_list);//语文必备知识点
        //text(more)
        stu_MyCurriculum_more=getActivity().findViewById(R.id.stu_MyCurriculum_more);
        stu_MentoringCommunity_more=getActivity().findViewById(R.id.stu_MentoringCommunity_more);
        stu_Knowledgepoint_more=getActivity().findViewById(R.id.stu_Knowledgepoint_more);

        //我的课程
        //数据源



        //答疑社区
        //数据源
        String[] Community_tille= stu_data.title;//标题，显示在item
        String[] Community_heatrate= stu_data.heatrate;
        List<Map<String, Object>> Community_listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < Community_tille.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("title", Community_tille[i]);
            showitem.put("heatrate", Community_heatrate[i]);
            Community_listitem.add(showitem);
        }
        //适配器
        SimpleAdapter sq_simpleAdapter=new SimpleAdapter(getContext(),//listview所在页面
                Community_listitem,//数据源
                R.layout.stu_item_mentoringcommunity,//item布局
                new String[]{"title","heatrate"},//list对应的键名
                new int[]{R.id.stu_item_MentoringCommunity_title,R.id.stu_item_MentoringCommunity_heatrate});//item布局控件id
        stu_MentoringCommunity_list.setAdapter(sq_simpleAdapter);//绑定适配器
        //item单击事件
        stu_MentoringCommunity_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), stu_knowlesgepoint_particulars.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });
        //textview更多more单击事件
        stu_MentoringCommunity_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), stu_knowlesgepoint_more.class);
                startActivity(intent);
            }
        });


        //语文必备知识点
        //数据源
        String[] Chinese_title= stu_data.title;//标题，显示在item
        List<Map<String, Object>> Chinese_listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < Chinese_title.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("content", Chinese_title[i]);
            Chinese_listitem.add(showitem);
        }
        //适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(getContext(),//listview所在页面
                Chinese_listitem,//数据源
                R.layout.stu_item,//item布局
                new String[]{"content"},//list对应的键名
                new int[]{R.id.textView});//item布局控件id
        stu_Knowledgepoint_list.setAdapter(simpleAdapter);//绑定适配器
        //item单击事件
        stu_Knowledgepoint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),stu_knowlesgepoint_particulars.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });
        //textview更多more单击事件
        stu_Knowledgepoint_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), stu_knowlesgepoint_more.class);
                startActivity(intent);
            }
        });

    }
}