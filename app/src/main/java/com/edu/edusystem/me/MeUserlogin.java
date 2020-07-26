package com.edu.edusystem.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.edu.edusystem.R;

public class MeUserlogin extends AppCompatActivity {
    private EditText tel,pwd;//电话 密码
    private Button go;//登录
    private TextView forget,sign;//忘记密码 注册
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_userlogin);
        /**
         * 绑定
         **/
        tel=findViewById(R.id.me_login_tel);
        pwd=findViewById(R.id.me_login_pwd);
        go=findViewById(R.id.me_login_but);
        forget=findViewById(R.id.me_login_forget);
        sign=findViewById(R.id.me_login_sign);

        //登录监听
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //忘记密码监听
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(MeUserlogin.this,MeLoginforget.class);
                startActivity(it);
            }
        });

        //注册监听
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MeUserlogin.this,MeLoginsign.class);
                startActivity(it);
            }
        });
    }
}
