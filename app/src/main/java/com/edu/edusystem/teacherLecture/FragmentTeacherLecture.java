package com.edu.edusystem.teacherLecture;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.edu.edusystem.R;
import com.edu.edusystem.tools.DBHelper;

public class FragmentTeacherLecture extends FragmentActivity implements View.OnClickListener{

    private SwipeRefreshLayout teacher_lecture_SwipeRefreshLayout;
    private ImageView[] attention_imageViews = new ImageView[15];
    private int[] ImageViewIds = new int[]{R.id.attention1,R.id.attention2,R.id.attention3,
            R.id.attention4,R.id.attention5,R.id.attention6,R.id.attention7,R.id.attention8,
            R.id.attention9,R.id.attention10,R.id.attention11,R.id.attention12,R.id.attention13,
            R.id.attention14,R.id.attention15
    };

    private boolean[] is_yes = new boolean[15];

    private String user;
    private String type;
    private String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teacher_lecture);
        TAG = this.getLocalClassName();
        teacher_lecture_SwipeRefreshLayout = findViewById(R.id.teacher_lecture_SwipeRefreshLayout);

        for (int i = 0;i<attention_imageViews.length;i++){
            attention_imageViews[i] = findViewById(ImageViewIds[i]);
            //attention_imageViews[i].setBa
            is_yes[i] = false;
            attention_imageViews[i].setOnClickListener(this);
        }

        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        type = sp.getString("type","");
        if(type.equals("1")){ // 如果是手机号登录
            user = sp.getString("user",""); // 获取用户手机号
        }else if(type.equals("2")) { // 如果是QQ号登录
            user = sp.getString("openId",""); // 获取QQ登录用户的openId
        }

        attention_imageViews[1].setBackgroundResource(R.drawable.favorite_yes);
        is_yes[1] = true;

        attention_imageViews[2].setBackgroundResource(R.drawable.favorite_no);
        is_yes[2] = false;

        teacher_lecture_SwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (teacher_lecture_SwipeRefreshLayout.isRefreshing()) {//如果正在刷新
                                    teacher_lecture_SwipeRefreshLayout.setRefreshing(false);//取消刷新
                                }
                                Toast.makeText(FragmentTeacherLecture.this, "刷新成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }.start();
            }
        });

    }

    /**
     * 添加喜欢
     */
    private void addFavorite(String teacher_json){
        if(type.equals("1")){//手机号登录
            final String sql = "update user_table set favorite_teacher=? where phone=?";
            final Object[] objects = new Object[]{teacher_json,user};
            new Thread(){
                @Override
                public void run() {
                    if(DBHelper.Update(sql,objects)){
                        Log.i(TAG,"成功添加喜欢的老师");
                    }

                }
            }.start();
        }else if(type.equals("2")){ // QQ登录
            final String sql = "update user_table set favorite_teacher=? where qq_openid=?";
            final Object[] objects = new Object[]{teacher_json,user};
            new Thread(){
                @Override
                public void run() {
                    if(DBHelper.Update(sql,objects)){
                        Log.i(TAG,"成功添加喜欢的老师");
                    }

                }
            }.start();
        }

    }

    /**
     * 移除喜欢
     */
    private void removeFavorite(String teacher_json){
        if(type.equals("1")){//手机号登录
            final String sql = "update user_table set favorite_teacher=? where phone=?";
            final Object[] objects = new Object[]{teacher_json,user};
            new Thread(){
                @Override
                public void run() {
                    if(DBHelper.Update(sql,objects)){
                        Log.i(TAG,"成功移除喜欢的老师");
                    }

                }
            }.start();
        }else if(type.equals("2")){ // QQ登录
            final String sql = "update user_table set favorite_teacher=? where qq_openid=?";
            final Object[] objects = new Object[]{teacher_json,user};
            new Thread(){
                @Override
                public void run() {
                    if(DBHelper.Update(sql,objects)){
                        Log.i(TAG,"成功移除喜欢的老师");
                    }

                }
            }.start();
        }

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        for (int i =0; i<attention_imageViews.length;i++){
            //判断是否为点击的那个控件
            if(id == ImageViewIds[i]){
                if(!is_yes[i]){
                    // 点击喜欢
                    is_yes[i] = true;
                    attention_imageViews[i].setBackgroundResource(R.drawable.favorite_yes);
                    Log.i("favorite_yes>>>>>>>","第"+i+"控件");
                    addFavorite("teadawdaw1");
                }else {
                    // 取消喜欢
                    is_yes[i] = false;
                    attention_imageViews[i].setBackgroundResource(R.drawable.favorite_no);
                    Log.i("favorite_no>>>>>>>","第"+i+"控件");
                    removeFavorite("");
                }
            }
        }

    }
}
