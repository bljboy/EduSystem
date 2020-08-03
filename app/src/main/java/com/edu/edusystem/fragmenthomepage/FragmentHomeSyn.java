package com.edu.edusystem.fragmenthomepage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.edusystem.R;
import com.edu.edusystem.fragmentsyn.SynSelectedCourseFragmentJump;
import com.edu.edusystem.teacherLecture.FragmentTeacherLecture;
import com.google.android.material.card.MaterialCardView;


public class FragmentHomeSyn extends Fragment {
    MaterialCardView syn_Selected_course;
    MaterialCardView syn_teacher_lecture;
    MaterialCardView syn_answer_questions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_syn, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        syn_Selected_course = getActivity().findViewById(R.id.syn_Selected_course);
        syn_teacher_lecture = getActivity().findViewById(R.id.syn_teacher_lecture);
        syn_answer_questions = getActivity().findViewById(R.id.syn_answer_questions);

        // 精选课程事件
        syn_Selected_course.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SynSelectedCourseFragmentJump.class);
                startActivity(intent);
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

            }
        });


    }

}