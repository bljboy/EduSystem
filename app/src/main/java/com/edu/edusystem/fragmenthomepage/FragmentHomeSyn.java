package com.edu.edusystem.fragmenthomepage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edu.edusystem.R;
import com.edu.edusystem.activity.AnswerQuestionsActivity;
import com.edu.edusystem.teacherLecture.FragmentTeacherLecture;
import com.google.android.material.card.MaterialCardView;


public class FragmentHomeSyn extends Fragment  implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout syn_SwipeRefreshLayout; //syn_SwipeRefreshLayout

    private MaterialCardView syn_Selected_course;
    private MaterialCardView syn_teacher_lecture;
    private MaterialCardView syn_answer_questions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.syn_home_hostfragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        syn_Selected_course = getActivity().findViewById(R.id.syn_Selected_course);
        syn_teacher_lecture = getActivity().findViewById(R.id.syn_teacher_lecture);
        syn_answer_questions = getActivity().findViewById(R.id.syn_answer_questions);
        syn_SwipeRefreshLayout = getActivity().findViewById(R.id.syn_SwipeRefreshLayout);


        syn_SwipeRefreshLayout.setOnRefreshListener(this);
        // 精选课程事件
        syn_Selected_course.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHomeSyn_to_synSelectedCourseFragmentJump);
            }
        });

        // 名师讲解事件
        syn_teacher_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FragmentTeacherLecture.class);
                startActivity(intent);
            }
        });

        // 答疑专区事件
        syn_answer_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AnswerQuestionsActivity.class));
            }
        });

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