package com.edu.edusystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.edusystem.fragmentAdapter.FragmentAdapter;
import com.edu.edusystem.fragmentThree.FragmentHomePage;
import com.edu.edusystem.fragmentThree.FragmentMe;
import com.edu.edusystem.fragmentThree.FragmentStudy;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * 这里的代码不要动哦,动了就坏了。刚刚写的注释2020-07-24 11:00
 */

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentAdapter fragmentAdapter;
    private BottomNavigationView bottomNavigationView;
    private int lastIndex;
    private AlertDialog dialog = null;
    private boolean isFirst;//是否第一次进入
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("one",MODE_PRIVATE);
        isFirst=sp.getBoolean("isFrist",true);
        if(isFirst)  showDialog();//显示对话框
        bottomNavigationView = findViewById(R.id.main_bottomNavigationView);
        initData();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_homepage:
                        setFragmentPosition(0);
                        break;
                    case R.id.menu_study:
                        setFragmentPosition(1);
                        break;
                    case R.id.menu_me:
                        setFragmentPosition(2);
                        break;

                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }


    public void initData() {
        list.add(new FragmentHomePage());
        list.add(new FragmentStudy());
        list.add(new FragmentMe());
        // 初始化展示
        setFragmentPosition(0);
    }

    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = list.get(position);
        Fragment lastFragment = list.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.host_layout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    //自定义对话框
    private void showDialog() {
        // 构建dialog显示的view布局
        View view= getLayoutInflater().from(this).inflate(R.layout.dialog, null);
        //绑定该布局下的控件
        TextView tv1=view.findViewById(R.id.tv_1);
        TextView tv_cancel=view.findViewById(R.id.tv_cancel);
        TextView tv1_agree=view.findViewById(R.id.tv_agree);
        if (dialog == null){
            // 创建AlertDialog对象
            dialog = new AlertDialog.Builder(this)
                    .create();
            dialog.show();
            //设置背景
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            // 设置点击可取消
            dialog.setCancelable(false);

            // 获取Window对象
            Window window = dialog.getWindow();
            // 设置显示视图内容
            window.setContentView(view);
            String str = "感谢您选择本APP!我们非常重视您的个人信息和隐私保护。" +
                    "为了更好地保障您的个人权益，在您使用我们的产品前，" +
                    "请务必审慎阅读《隐私政策》和《用户协议》内的所有条款，" +
                    "尤其是:1.我们对您的个人信息的收集/保存/使用/对外提供/保护等规则条款，以及您的用户权利等条款; " +
                    "2. 约定我们的限制责任、免责条款; 3.其他以颜色或加粗进行标识的重要条款。您点击“同意并继续”的行为即表示您已阅读完毕并同意以上协议的全部内容。" +
                    "如您同意以上协议内容，请点击“同意并继续”，开始使用我们的产品和服务!";


            final int star = str.indexOf("《");//最后一个出现的位置
            final int end = str.lastIndexOf("《");//最后一个出现的位置

            SpannableStringBuilder spannableString = new SpannableStringBuilder();
            spannableString.append(str);
            ClickableSpan clickableSpanpvy = new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    Log.i("ssssssssssss","ces");
                }
                public void updateDrawState(TextPaint ds) {
                    /**set textColor**/
                    ds.setColor(ds.linkColor);
                    /**Remove the underline**/
                    ds.setUnderlineText(false);
                }
            };

            //点击隐私
            spannableString.setSpan(clickableSpanpvy, star, star+6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);


            ClickableSpan clickableSpanpcy=new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    Toast.makeText(MainActivity.this, "测试2", Toast.LENGTH_SHORT).show();

                }
                public void updateDrawState(TextPaint ds) {
                    /**set textColor**/
                    ds.setColor(ds.linkColor);
                    /**Remove the underline**/
                    ds.setUnderlineText(false);
                }
            };
            //点击用户协议
            spannableString.setSpan(clickableSpanpcy, end, end+6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#03A9F4"));

            spannableString.setSpan(colorSpan,star,star+6,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            spannableString.setSpan(colorSpan,end,end+6,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            tv1.setText(spannableString);
            tv1.setMovementMethod(LinkMovementMethod.getInstance());
            //取消按钮
            tv_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        finish();
                }
            });
            //确定按钮
            tv1_agree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sp=getSharedPreferences("one", MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("isFrist",false);
                    editor.commit();
                    dialog.cancel();
                }
            });
        }else {
            dialog.show();
        }


    }
}