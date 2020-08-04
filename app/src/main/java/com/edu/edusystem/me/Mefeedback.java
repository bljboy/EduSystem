package com.edu.edusystem.me;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;

//用户反馈
public class Mefeedback extends AppCompatActivity {
    private EditText et_title,et_content;
    private Button yes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_feedbake);

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

        et_title=findViewById(R.id.et_title);
        et_content=findViewById(R.id.et_content);
        yes=findViewById(R.id.but);//提交按钮
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_content.getText().toString().length()>0&&et_title.getText().toString().length()>0)
                {
                    finish();
                    Toast.makeText(Mefeedback.this,"提交成功",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(et_content.getText().toString().length()>0)
                        Toast.makeText(Mefeedback.this,"请输入标题",Toast.LENGTH_SHORT).show();
                    else if(et_title.getText().toString().length()>0)
                        Toast.makeText(Mefeedback.this,"请输入内容",Toast.LENGTH_SHORT).show();
                    else
                    Toast.makeText(Mefeedback.this,"请输入",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
