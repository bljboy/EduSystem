package com.edu.edusystem.fragmentThree;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.edusystem.R;
import com.edu.edusystem.tools.CircleImageView;
import com.edu.edusystem.me.MeAftlogin;
import com.edu.edusystem.me.Mefeedback;
import com.edu.edusystem.me.Mepriage;
import com.edu.edusystem.tools.CircleImageView2;
import com.squareup.picasso.Picasso;


/**
 * --------我的信息------
 * -------- 功能：--------
 * 注册登入、我的收藏、用户反馈、关注的老师
 */

public class FragmentMe extends Fragment {

    private LinearLayout me_username, me_favorite, me_feedback, me_followee, me_pvypcy;
    /**
     * 定义
     * 注册登录按钮
     * 我的收藏
     * 用户反馈
     * 关注的老师
     * 隐私和政策
     **/
    private SharedPreferences preferences;
    private TextView me_logtv;
    private CircleImageView2 me_img;


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

        me_username = getActivity().findViewById(R.id.me_user);//user
        me_favorite = getActivity().findViewById(R.id.me_favorite);//我的收藏
        me_feedback = getActivity().findViewById(R.id.me_feedback);//用户反馈
        me_followee = getActivity().findViewById(R.id.me_followee);//关注的老师
        me_pvypcy = getActivity().findViewById(R.id.me_pvypcy);//隐私和政策
        me_logtv = getActivity().findViewById(R.id.user_tv);//显示用户名
        me_img = getActivity().findViewById(R.id.me_img);//头像
        preferences = getActivity().getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        String type, figureurl_qq, username;
        type = preferences.getString("type", "");

        //加载图片url到ImageView
        if (type.equals("2")) {
            figureurl_qq = preferences.getString("figureurl_qq", "");
            Log.i("figureurl_qq>>>>>","figureurl_qq///////"+figureurl_qq);
            Picasso.with(getContext()).load(figureurl_qq).into(me_img);
            username = preferences.getString("nickname", "");
            me_logtv.setText(username);
        }
        if (type.equals("1")) {
            username = preferences.getString("user", "");
            me_logtv.setText(username);
        }
        //个人信息
        me_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MeAftlogin.class);
                startActivity(it);

            }
        });

        //我的收藏监听事件
        me_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"功能未开发",Toast.LENGTH_SHORT).show();
            }
        });

        //用户反馈监听事件
        me_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), Mefeedback.class);
                startActivity(it);
            }
        });

        //关注的老师监听事件
        me_followee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"功能未开发",Toast.LENGTH_SHORT).show();
            }
        });

        //隐私与政策监听事件
        me_pvypcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), Mepriage.class);
                startActivity(it);
            }
        });
    }
}