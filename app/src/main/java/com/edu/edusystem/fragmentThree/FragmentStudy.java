package com.edu.edusystem.fragmentThree;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.edusystem.R;


/***
 * ---------学习----------
 * ---------功能：---------
 * 答疑社区、选课功能、语文必备知识点
 */
public class FragmentStudy extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

    //功能实现操作
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textView = getActivity().findViewById(R.id.te);
//        textView.setText("sssssssssssssssss");
    }
}