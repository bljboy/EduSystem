package com.edu.edusystem.me;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;

public class MeAftlogin extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_aftlogin);
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
