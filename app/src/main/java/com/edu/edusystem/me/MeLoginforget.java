package com.edu.edusystem.me;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.edu.edusystem.R;
//忘记密码
public class MeLoginforget extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_login_forget);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();//Activity不可见时,杀掉;
    }
}
