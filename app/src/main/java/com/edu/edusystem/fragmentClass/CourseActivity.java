package com.edu.edusystem.fragmentClass;

import androidx.appcompat.app.AppCompatActivity;
import com.edu.edusystem.R;
import com.google.android.material.appbar.MaterialToolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * 语文
 */
public class CourseActivity extends AppCompatActivity {

    private MaterialToolbar course_MaterialToolbar;
    private TextView course_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        course_MaterialToolbar = findViewById(R.id.course_MaterialToolbar);
        course_name = findViewById(R.id.course_name);

        Intent intent = getIntent();
        String url = intent.getStringExtra("course");
        String name = intent.getStringExtra("name");
        course_name.setText(name);

        WebView china_webView = findViewById(R.id.class_webView);
        china_webView.loadUrl(url);

        course_MaterialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
