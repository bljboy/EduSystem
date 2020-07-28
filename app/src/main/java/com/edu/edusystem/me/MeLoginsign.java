package com.edu.edusystem.me;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.edu.edusystem.R;
//注册界面
public class MeLoginsign extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_login_sign);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();//结束不可见的Activity
    }
}
