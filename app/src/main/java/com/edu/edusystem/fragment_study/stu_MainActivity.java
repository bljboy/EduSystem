package com.edu.edusystem.fragment_study;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.edu.edusystem.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stu_MainActivity extends AppCompatActivity {

    ListView stu_MyCurriculum_list,stu_MentoringCommunity_list,stu_Knowledgepoint_list;
    TextView stu_MyCurriculum_more,stu_MentoringCommunity_more,stu_Knowledgepoint_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_study);

        Log.i("ddddddddddddddddd","wewewewewewewewewewewewewewewewewewewewewewewe");
        //listview
        stu_MyCurriculum_list=findViewById(R.id.stu_MyCurriculum_list);//我的课程
        stu_MentoringCommunity_list=findViewById(R.id.stu_MentoringCommunity_list);//答疑社区
        stu_Knowledgepoint_list=findViewById(R.id.stu_Knowledgepoint_list);//语文必备知识点
        //text(more)
        stu_MyCurriculum_more=findViewById(R.id.stu_MyCurriculum_more);
        stu_MentoringCommunity_more=findViewById(R.id.stu_MentoringCommunity_more);
        stu_Knowledgepoint_more=findViewById(R.id.stu_Knowledgepoint_more);

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
        SimpleAdapter sq_simpleAdapter=new SimpleAdapter(stu_MainActivity.this,//listview所在页面
                Community_listitem,//数据源
                R.layout.stu_item_mentoringcommunity,//item布局
                new String[]{"title","heatrate"},//list对应的键名
                new int[]{R.id.stu_item_MentoringCommunity_title,R.id.stu_item_MentoringCommunity_heatrate});//item布局控件id
        stu_MentoringCommunity_list.setAdapter(sq_simpleAdapter);//绑定适配器
        //item单击事件
        stu_MentoringCommunity_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(stu_MainActivity.this,stu_knowlesgepoint_particulars.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });
        //textview更多more单击事件
        stu_MentoringCommunity_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(stu_MainActivity.this, stu_knowlesgepoint_more.class);
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
            Log.i("ddddddddddddddddd",Chinese_title[i]);
            Chinese_listitem.add(showitem);
        }
        //适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(stu_MainActivity.this,//listview所在页面
                Chinese_listitem,//数据源
                R.layout.stu_item,//item布局
                new String[]{"content"},//list对应的键名
                new int[]{R.id.textView});//item布局控件id
        stu_Knowledgepoint_list.setAdapter(simpleAdapter);//绑定适配器
        //item单击事件
        stu_Knowledgepoint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(stu_MainActivity.this,stu_knowlesgepoint_particulars.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });
        //textview更多more单击事件
        stu_Knowledgepoint_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(stu_MainActivity.this, stu_knowlesgepoint_more.class);
                startActivity(intent);
            }
        });

    }
}