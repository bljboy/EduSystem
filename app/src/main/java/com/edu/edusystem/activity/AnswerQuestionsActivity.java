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
