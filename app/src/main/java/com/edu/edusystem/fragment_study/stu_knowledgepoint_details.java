package com.edu.edusystem.fragment_study;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;

public class stu_knowledgepoint_details extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_knowledgepoint_details);

        tv=findViewById(R.id.textView);

        Intent intent=getIntent();
        String  serialnumber=intent.getStringExtra("serialnumber");

        String[] title= stu_data.title;
        String[] content= stu_data.content;
        tv.setText(title[Integer.parseInt(serialnumber)]+"\n"+content[Integer.parseInt(serialnumber)]);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());//内容文字可滑动

        Toolbar toolbar=findViewById(R.id.toolbar);//绑定toolbar
        toolbar.setTitle(title[Integer.parseInt(serialnumber)]);
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