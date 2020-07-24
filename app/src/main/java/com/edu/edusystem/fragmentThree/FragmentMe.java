package com.edu.edusystem.fragmentThree;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.edusystem.R;


/**
 * --------我的信息------
 * -------- 功能：--------
 * 注册登入、我的收藏、用户反馈、关注的老师
 */

public class FragmentMe extends Fragment {

private  TextView me_username,me_favorite,me_feedback,me_followee,me_pvypcy;
/**
 * 定义
 * user
 * 我的收藏
 * 用户反馈
 * 关注的老师
 * 隐私和政策
**/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    //功能实现操作
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textView = getActivity().findViewById(R.id.te);
//        textView.setText("sssssssssssssssss");
        me_username=getActivity().findViewById(R.id.me_username);//user
        me_favorite=getActivity().findViewById(R.id.me_favorite);//我的收藏
        me_feedback=getActivity().findViewById(R.id.me_feedback);//用户反馈
        me_followee=getActivity().findViewById(R.id.me_followee);//关注的老师
        me_pvypcy=getActivity().findViewById(R.id.me_pvypcy);//隐私和政策

        //user监听事件
        me_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //我的收藏监听事件
        me_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //用户反馈监听事件
        me_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //关注的老师监听事件
        me_followee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //隐私与政策监听事件
        me_pvypcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}