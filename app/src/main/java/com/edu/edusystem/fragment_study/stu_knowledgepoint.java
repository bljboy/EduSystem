package com.edu.edusystem.fragment_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stu_knowledgepoint extends AppCompatActivity {

    ListView lv;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_knowledgepoint);

        lv=findViewById(R.id.stu_Knowledgepoint_listview);

        //数据源
        String[] knowledgrpoint_title= stu_data.title;//标题，显示在item
        String[] knowledgrpoint_content= stu_data.content;//标题，显示在item
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < knowledgrpoint_title.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("title", knowledgrpoint_title[i]);
            showitem.put("content", knowledgrpoint_content[i]);
            listitem.add(showitem);
        }
        //适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(stu_knowledgepoint.this,//listview所在页面
                listitem,//数据源
                R.layout.stu_knowledgepoint_item,//item布局
                new String[]{"title","content"},//list对应的键名
                new int[]{R.id.title,R.id.content});//item布局控件id
        lv.setAdapter(simpleAdapter);//绑定适配器

        //item单击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(stu_knowledgepoint.this,stu_knowledgepoint_details.class);
                intent.putExtra("serialnumber",i+"");
                startActivity(intent);
            }
        });

        Toolbar toolbar=findViewById(R.id.toolbar);//绑定toolbar
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {//sdk21以上的沉浸式方法
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//字体颜色
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(0);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}