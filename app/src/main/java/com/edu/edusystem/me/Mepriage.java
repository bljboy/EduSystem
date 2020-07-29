package com.edu.edusystem.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.edu.edusystem.Agreement;
import com.edu.edusystem.Privacy;
import com.edu.edusystem.R;

public class Mepriage extends AppCompatActivity {
    private LinearLayout me_pry,me_age;//用户隐私政策 用户服务协议
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_pryage);
        me_pry=findViewById(R.id.me_pry);
        me_age=findViewById(R.id.me_age);
        //隐私政策
        me_pry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Mepriage.this, Privacy.class);
                startActivity(it);
            }
        });
        //服务协议
        me_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Mepriage.this, Agreement.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
