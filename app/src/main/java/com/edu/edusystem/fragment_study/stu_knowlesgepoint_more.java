package com.edu.edusystem.fragment_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.edu.edusystem.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stu_knowlesgepoint_more extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_knowledgepoint_more);

        lv=findViewById(R.id.stu_Knowledgepoint_more_listview);

        //数据源
        String[] Chinese_title= stu_data.title;//标题，显示在item
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < Chinese_title.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("title", Chinese_title[i]);
            listitem.add(showitem);
        }
        //适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(stu_knowlesgepoint_more.this,//listview所在页面
                listitem,//数据源
                R.layout.stu_item,//item布局
                new String[]{"title"},//list对应的键名
                new int[]{R.id.textView});//item布局控件id
        lv.setAdapter(simpleAdapter);//绑定适配器

        //item单击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(stu_knowlesgepoint_more.this,stu_knowlesgepoint_particulars.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });

    }
}