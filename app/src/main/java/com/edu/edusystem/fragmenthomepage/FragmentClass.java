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
import com.edu.edusystem.fragmentClass.FragmentArts;
import com.google.android.material.card.MaterialCardView;


public class FragmentClass extends Fragment implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener{
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
    private MaterialCardView class_arts_exam; // 艺考
    private MaterialCardView class_china; // 语文
    private MaterialCardView class_math; // 数学
    private MaterialCardView class_english; // 英语
    private MaterialCardView class_physics; // 物理
    private MaterialCardView class_chemistry; // 化学
    private MaterialCardView class_biology; // 生物
    private MaterialCardView class_history; // 历史
    private MaterialCardView class_politics; // 政治
    private MaterialCardView class_geography; // 地理
    private SwipeRefreshLayout class_SwipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_class, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 控件绑定
        initView();

        //事件绑定
        initListener();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.teacher_card1: // 艺考
                //Toast.makeText(getContext(),"艺考",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(),FragmentArts.class);
                startActivity(intent);

                break;
            case R.id.teacher_card2: // 语文
                Toast.makeText(getContext(),"语文",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card3: // 数学
                Toast.makeText(getContext(),"数学",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card4: // 英语
                Toast.makeText(getContext(),"英语",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card5: // 物理
                Toast.makeText(getContext(),"物理",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card6: // 化学
                Toast.makeText(getContext(),"化学",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card7: // 生物
                Toast.makeText(getContext(),"生物",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card8: // 历史
                Toast.makeText(getContext(),"历史",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card9: // 政治
                Toast.makeText(getContext(),"政治",Toast.LENGTH_LONG).show();
                break;
            case R.id.teacher_card10: // 地理
                Toast.makeText(getContext(),"地理",Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * 绑定卡片id
     */
    private void initView(){
        class_arts_exam = getActivity().findViewById(R.id.teacher_card1);
        class_china = getActivity().findViewById(R.id.teacher_card2);
        class_math = getActivity().findViewById(R.id.teacher_card3);
        class_english = getActivity().findViewById(R.id.teacher_card4);
        class_physics = getActivity().findViewById(R.id.teacher_card5);
        class_chemistry = getActivity().findViewById(R.id.teacher_card6);
        class_biology = getActivity().findViewById(R.id.teacher_card7);
        class_history = getActivity().findViewById(R.id.teacher_card8);
        class_politics = getActivity().findViewById(R.id.teacher_card9);
        class_geography = getActivity().findViewById(R.id.teacher_card10);

        class_SwipeRefreshLayout = getActivity().findViewById(R.id.class_SwipeRefreshLayout);
    }

    /**
     * 对卡片绑定单击监听事件
     */
    private void initListener(){
        class_arts_exam.setOnClickListener(this);
        class_china.setOnClickListener(this);
        class_math.setOnClickListener(this);
        class_english.setOnClickListener(this);
        class_physics.setOnClickListener(this);
        class_chemistry.setOnClickListener(this);
        class_biology.setOnClickListener(this);
        class_history.setOnClickListener(this);
        class_politics.setOnClickListener(this);
        class_geography.setOnClickListener(this);

        class_SwipeRefreshLayout.setOnRefreshListener(this);
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
                        if (class_SwipeRefreshLayout.isRefreshing()) {//如果正在刷新
                            class_SwipeRefreshLayout.setRefreshing(false);//取消刷新
                        }
                        Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();
    }
}