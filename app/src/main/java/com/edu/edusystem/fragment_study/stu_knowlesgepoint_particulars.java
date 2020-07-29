package com.edu.edusystem.fragment_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.edu.edusystem.R;

public class stu_knowlesgepoint_particulars extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_knowlesgepoint_particulars);

        tv=findViewById(R.id.particulars);

        Intent intent=getIntent();
        String  serialnumber=intent.getStringExtra("serialnumber");

        String[] Chinese_title= stu_data.title;
        String[] Chinese_content= stu_data.content;
        tv.setText(Chinese_title[Integer.parseInt(serialnumber)]+"\n"+Chinese_content[Integer.parseInt(serialnumber)]);

    }
}