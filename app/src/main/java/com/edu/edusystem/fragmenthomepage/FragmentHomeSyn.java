package com.edu.edusystem.fragmenthomepage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.edusystem.R;
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

        syn_Selected_course.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHomeSyn_to_synSelectedCourseFragmentJump);
            }
        });
    }

}