package com.edu.edusystem.me;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.edu.edusystem.R;
import com.edu.edusystem.dbtools.DBHelper;

public class MeAftlogin extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout me_aft_sex;
    private EditText aft_user,aft_age;
    private TextView aft_sex;
    private SharedPreferences preferences;
    private String name,sex,age,type;
    private Button save,quit;
    private SharedPreferences.Editor editor;
    private AlertDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_aftlogin);
    //绑定显示控件
        aft_user=findViewById(R.id.aft_name);
        aft_age=findViewById(R.id.aft_age);
        aft_sex=findViewById(R.id.aft_sex);
        //绑定监听控件
        me_aft_sex=findViewById(R.id.me_aft_sex);//监听性别弹出dialog
        save=findViewById(R.id.me_aft_save);//保存按钮
        quit=findViewById(R.id.me_aft_quit);//退出登录

        me_aft_sex.setOnClickListener(this);
        save.setOnClickListener(this);
        quit.setOnClickListener(this);

        preferences=getSharedPreferences("userInfo",MODE_PRIVATE);//数据读取
        editor=preferences.edit();
        type=preferences.getString("type","");
        name=preferences.getString("user","");
        sex=preferences.getString("sex","");
        age=preferences.getString("age","");

        aft_user.setText(name);
        aft_sex.setText(sex);
        aft_age.setText(age);
        Toolbar toolbar=findViewById(R.id.toolbar);//绑定toolbar
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {//sdk21以上的沉浸式方法
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//？
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//状态栏文字颜色
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(0);
        }
        //返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=preferences.getString("user","");
                sex=preferences.getString("sex","");
                age=preferences.getString("age","");
                if(name.equals(aft_user.getText().toString())&&sex.equals(aft_sex.getText().toString())&&age.equals(aft_age.getText().toString()))
                    finish();
                else
                    showdialog();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //性别选择
            case R.id.me_aft_sex:
                final AlertDialog.Builder builder = new AlertDialog.Builder(MeAftlogin.this); //定义一个AlertDialog
                String[] strarr = {"男","女"};
                builder.setItems(strarr, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface arg0, int arg1)
                    {
                        sex = "男";
                        // 自动生成的方法存根
                        if (arg1 == 0) {//男
                            sex = "男";
                            aft_sex.setText(sex);
                        }else {//女
                            sex = "女";
                            aft_sex.setText(sex);
                        }

                    }
                });

                builder.setCancelable(false);
                builder.show();
                break;
            case R.id.me_aft_save:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String sql="";
                        String id="";

                            if (type.equals("1")) {
                                sql = "update user_table set username=? sex=? age=? where phone=?";
                                id = preferences.getString("phone", "");
                                editor.putString("phone",id);
                            }
                            if (type.equals("2")) {
                                sql = "update user_table set username=? sex=? age=? where qq_opendid=?";
                                id = preferences.getString("openId", "");
                                editor.putString("openId",id);
                            }
                            name=aft_user.getText().toString();
                            sex=aft_sex.getText().toString();
                            age=aft_age.getText().toString();
                            Object[] objects=new Object[]{name,sex,age,id};
                            if(sql!="")  DBHelper.Update(sql,objects);//数据写入
                            editor.putString("name",aft_user.getText().toString());
                            editor.putString("sex",aft_sex.getText().toString());
                            editor.putString("age",aft_age.getText().toString());
                            editor.apply();

                    }
                }).start();
                Toast.makeText(MeAftlogin.this,"保存成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_aft_quit:
                editor.clear();
                editor.apply();
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {

            name = preferences.getString("user", "");
            sex = preferences.getString("sex", "");
            age = preferences.getString("age", "");
            if (name.equals(aft_user.getText().toString()) && sex.equals(aft_sex.getText().toString()) && age.equals(aft_age.getText().toString()))
                finish();
            else
                showdialog();
        }
        return false;
    }

    public  void showdialog(){
    View view = getLayoutInflater().from(this).inflate(R.layout.dialog,null);
    //绑定该布局下的控件
    TextView tv_cancel = view.findViewById(R.id.tv_cancel);
    TextView tv_agree = view.findViewById(R.id.tv_agree);
        if (dialog == null) {
        // 创建AlertDialog对象
        dialog = new AlertDialog.Builder(this)
                .create();
        dialog.show();
        //设置背景
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // 设置点击不可取消
        dialog.setCancelable(false);

        // 获取Window对象
        Window window = dialog.getWindow();
        // 设置显示视图内容
        window.setContentView(view);
    }
			else
                    dialog.show();
			//保存
		tv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String sql="";
                        String id="";

                            if (type.equals("1")) {
                                sql = "update user_table set username=? sex=? age=? where phone=?";
                                id = preferences.getString("phone", "");
                                editor.putString("phone",id);
                            }
                            if (type.equals("2")) {
                                sql = "update user_table set username=? sex=? age=? where qq_opendid=?";
                                id = preferences.getString("openId", "");
                                editor.putString("openId",id);
                            }
                            name=aft_user.getText().toString();
                            sex=aft_sex.getText().toString();
                            age=aft_age.getText().toString();
                            Object[] objects=new Object[]{name,sex,age,id};
                            if(sql!="")
                            DBHelper.Update(sql,objects);
                            editor.putString("name",aft_user.getText().toString());
                            editor.putString("sex",aft_sex.getText().toString());
                            editor.putString("age",aft_age.getText().toString());
                            editor.apply();

//                        else
//                            Toast.makeText(MeAftlogin.this,"Error",Toast.LENGTH_SHORT).show();使用toast报错
//                        由于type不可能为空这个bug不急于解决

                    }
                }).start();
                dialog.cancel();
                finish();
            }

        });
		//不保存
		tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                finish();
            }
        });
    }
}
