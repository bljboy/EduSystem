package com.edu.edusystem.fragmenthomepage;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edu.edusystem.R;

import com.edu.edusystem.teacherLecture.FragmentTeacherLecture;
import com.google.android.material.card.MaterialCardView;

public class FragmentSyn extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout syn_SwipeRefreshLayout;
    //卡片
    private MaterialCardView syn_Selected_course; // 精选课程
    private MaterialCardView syn_teacher_lecture; // 名师讲解
    private MaterialCardView syn_answer_questions; // 答疑专区


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_syn, container, false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        //刷新控件的下拉刷新方法 这里做个刷新1秒钟再提示刷新成功
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
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (syn_SwipeRefreshLayout.isRefreshing()) {//如果正在刷新
                                syn_SwipeRefreshLayout.setRefreshing(false);//取消刷新
                            }
                            Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }.start();
        }
}