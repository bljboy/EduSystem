package com.edu.edusystem.me;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;

public class MeAftlogin extends AppCompatActivity {
    private LinearLayout me_aft_user,me_aft_sex,me_aft_age;
    private TextView aft_user,aft_sex,aft_age;
    private SharedPreferences preferences;
    private String name,sex,age,type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_aftlogin);
        preferences=getSharedPreferences("userInfo",MODE_PRIVATE);//数据读取
        type=preferences.getString("type","");
        if(type.equals("1"))
        {
            name=preferences.getString("user","");
            sex=preferences.getString("sex","");
            age=preferences.getString("age","");
        }
        else if(type.equals("2"))
        {
            name=preferences.getString("nickname","");
            sex=preferences.getString("sex","");
            age=preferences.getString("age","");
        }
        else
            Toast.makeText(MeAftlogin.this,"数据读取error",Toast.LENGTH_SHORT).show();
        aft_user.setText(name);
        aft_sex.setText(sex);
        aft_age.setText(age);
        Toolbar toolbar=findViewById(R.id.toolbar);//绑定toolbar
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {//sdk21以上的沉浸式方法
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//？
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//状态栏文字颜色
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
}
