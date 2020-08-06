package com.edu.edusystem.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.edu.edusystem.R;
import com.google.android.material.appbar.MaterialToolbar;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AnswerQuestionsActivity extends AppCompatActivity {

    private MaterialToolbar answer_questions_MaterialToolbar;
    private WebView answer_questions_WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questions);
        answer_questions_WebView = findViewById(R.id.answer_questions_WebView);
        answer_questions_MaterialToolbar = findViewById(R.id.answer_questions_MaterialToolbar);

        //WebSettings webSettings = answer_questions_WebView.getSettings();
        //webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        //webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        //webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        //webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //answer_questions
        answer_questions_WebView.loadUrl("file:///android_asset/answer_questions.html");


        answer_questions_MaterialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
