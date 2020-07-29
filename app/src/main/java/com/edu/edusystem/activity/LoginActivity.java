package com.edu.edusystem.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.edusystem.MainActivity;
import com.edu.edusystem.R;
import com.edu.edusystem.tools.DBHelper;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class LoginActivity extends AppCompatActivity {

    //QQ登录功能
    private final String APP_ID = "101890397";
    private Tencent mTencent;
    private BaseUiListener mIuiListener;
    private UserInfo mUserInfo;

    // MobSMS短信功能
    private EventHandler eh;
    private String phone;

    //控件
    private EditText log_et_phone; // 手机号
    private EditText log_et_auth_code; // 验证码
    private TextView log_getCode; // 获取验证码
    private ImageView log_loginBtn; // 登录按钮
    private ImageView log_qq_login; // QQ登录按钮
    private CheckBox log_agree_chBox; // 我同意复选框
    private TextView log_agreement; // 用户协议

    private String favorite_teacher_json;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            //QQ登录回调
            Tencent.onActivityResultData(requestCode, resultCode, data, mIuiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    //手机号登录用户查询该用户喜欢的老师
    private void queryFavoriteTeacher(final String sql, final Object[] objects) {


        List<HashMap<String, Object>> list = DBHelper.getList(sql, objects);
        for (HashMap<String, Object> map : list) {
            favorite_teacher_json = (String) map.get("favorite_teacher");
        }


        Log.i("favorite_teacher>>>>>>>>>>", favorite_teacher_json + "");

        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("type", "1"); // 1是手机号登录
        editor.putString("user", phone);
        editor.putString("favorite_teacher", favorite_teacher_json);
        editor.apply();


    }

    private void executeSQL(final String sql, final Object[] objects) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (objects == null) {
                    DBHelper.Update(sql, null);
                } else {
                    DBHelper.Update(sql, objects);
                }

            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //查询用户喜欢的老师
                String sqlString = "select favorite_teacher from user_table where phone=?";
                queryFavoriteTeacher(sqlString, new Object[]{phone});
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String type = sharedPreferences.getString("type","");
        if(!type.equals("")){
            Log.i("LoginActivity>>>>>>>>","本地已保存过用户信息");
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            this.finish();
        }

        sp = getSharedPreferences("one", MODE_PRIVATE);
        isFirst = sp.getBoolean("isFrist", true);
        if (isFirst) {
            showDialog();//显示对话框
        }

        log_et_phone = findViewById(R.id.log_et_phone);
        log_et_auth_code = findViewById(R.id.log_et_auth_code);
        log_getCode = findViewById(R.id.log_getCode);
        log_loginBtn = findViewById(R.id.log_loginBtn);
        log_qq_login = findViewById(R.id.log_qq_login);
        log_agree_chBox = findViewById(R.id.log_agree_chBox);
        log_agreement = findViewById(R.id.log_agreement);

        // QQ登录实例
        mTencent = Tencent.createInstance(APP_ID, LoginActivity.this.getApplicationContext());

        eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //验证验证码成功
                        //handler.sendEmptyMessage(VERIFY_SUCCESS);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //跳转到主页面
                                //Toast.makeText(LoginActivity.this, "验证成功", Toast.LENGTH_SHORT).show();

                                //保存用户输入的手机号到用户表
                                String sql = "insert into user_table(phone,favorite_teacher) values (?,?)";
                                Object[] objects = new Object[]{phone, "{\"data\":[]}"};
                                executeSQL(sql, objects);


//


                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                LoginActivity.this.finish();
                            }
                        });

                    }

                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                        //handler.sendEmptyMessage(ACQUIRE_SUCCESS);
                        //handler.sendEmptyMessage(ACQUIRE_SUCCESS);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                log_getCode.setEnabled(false);
                                Toast.makeText(LoginActivity.this, "获取验证码成功", Toast.LENGTH_SHORT).show();
                                // 获取验证码按钮倒计时60S
                                new CountDownTimer(60000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        log_getCode.setText(millisUntilFinished / 1000 + "S");
                                    }

                                    @Override
                                    public void onFinish() {
                                        log_getCode.setEnabled(true);
                                        log_getCode.setText("重新发送");
                                    }
                                }.start();
                            }
                        });
                    }

                    if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //不支持当前国家，返回支持发送验证码的国家列表
                        //handler.sendEmptyMessage(NONSUPPORT);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                    String res = ((Throwable) data).getMessage();
                    try {
                        assert res != null; // 断言，如果res为空 直接抛出异常
                        JSONObject object = new JSONObject(res);
                        String status = object.getString("status");
                        Log.i("status错误码", status);
                        final String description = object.getString("description");//这里可能会无description字段异常，运行catch代码块
                        if (!description.equals("") || description != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, description, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        try {
                            JSONObject object = new JSONObject(res);
                            final String detail = object.getString("detail");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, detail, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        };
        //注册 eventHandler
        SMSSDK.registerEventHandler(eh);

        //获取验证码
        log_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = log_et_phone.getText().toString();
                SMSSDK.getVerificationCode("", "86", phone);// 获取验证码，在监听中返回

            }
        });

        //提交验证码,登录
        log_loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = log_et_phone.getText().toString();
                if ((log_et_phone.getText().toString()).equals("")
                        || (log_et_auth_code.getText().toString()).equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入手机号和验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!log_agree_chBox.isChecked()) {
                    Toast.makeText(LoginActivity.this, "请勾选用户协议", Toast.LENGTH_SHORT).show();
                    return;
                }
                String code = log_et_auth_code.getText().toString();
                SMSSDK.submitVerificationCode("86", phone, code); //提交短信验证码，在监听中返回
            }
        });

        //用户协议
        log_agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转到用户协议页面
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //QQ快捷登录
        log_qq_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!log_agree_chBox.isChecked()) {
                    Toast.makeText(LoginActivity.this, "请勾选用户协议", Toast.LENGTH_SHORT).show();
                    return;
                }
                mIuiListener = new BaseUiListener();
                mTencent.login(LoginActivity.this, "all", mIuiListener);
            }
        });
    }

    // 使用完EventHandler需注销，否则可能出现内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eh);
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * <p>
     * onComplete完成 onError错误 onCancel取消
     */

    private class BaseUiListener implements IUiListener {

        @Override

        public void onComplete(Object response) {

            Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();

            Log.i("QQ登录返回信息>>>>>>", response.toString());

            JSONObject obj = (JSONObject) response;

            try {

                final String openID = obj.getString("openid");

                String accessToken = obj.getString("access_token");

                String expires = obj.getString("expires_in");

                mTencent.setOpenId(openID);

                mTencent.setAccessToken(accessToken, expires);

                QQToken qqToken = mTencent.getQQToken();

                mUserInfo = new UserInfo(getApplicationContext(), qqToken);

                mUserInfo.getUserInfo(new IUiListener() {

                    @Override

                    public void onComplete(Object response) {
                        /**
                         * "figureurl_qq_2":"http://thirdqq.qlogo.cn/g?b=oidb&k=AYAKviaZlLeJcw3aMIIIOJg&s=100&t=1587564846"
                         *
                         * {"ret":0,"msg":"","is_lost":0,"nickname":"‭‭","gender":"男","gender_type":1,
                         * "province":"","city":"","year":"1999","constellation":"",
                         * "figureurl":"http:\/\/qzapp.qlogo.cn\/qzapp\/101879204\/EF8674CD8CE3530A162CDF78AD293ADA\/30",
                         * "figureurl_1":"http:\/\/qzapp.qlogo.cn\/qzapp\/101879204\/EF8674CD8CE3530A162CDF78AD293ADA\/50",
                         * "figureurl_2":"http:\/\/qzapp.qlogo.cn\/qzapp\/101879204\/EF8674CD8CE3530A162CDF78AD293ADA\/100",
                         * "figureurl_qq_1":"http:\/\/thirdqq.qlogo.cn\/g?b=oidb&k=AYAKviaZlLeJcw3aMIIIOJg&s=40&t=1587564846",
                         * "figureurl_qq_2":"http:\/\/thirdqq.qlogo.cn\/g?b=oidb&k=AYAKviaZlLeJcw3aMIIIOJg&s=100&t=1587564846",
                         * "figureurl_qq":"http:\/\/thirdqq.qlogo.cn\/g?b=oidb&k=AYAKviaZlLeJcw3aMIIIOJg&s=640&t=1587564846",
                         * "figureurl_type":"1","is_yellow_vip":"0","vip":"0","yellow_vip_level":"0","level":"0",
                         * "is_yellow_year_vip":"0"}
                         */
                        //Log.i("TAG", "登录成功" + response.toString());
                        JSONObject obj = (JSONObject) response;
                        try {
                            final String nickname = obj.getString("nickname");
                            final String sex = obj.getString("gender"); //性别
                            String year = obj.getString("year"); // 生日年
                            String figureurl_qq_1 = obj.getString("figureurl_qq_1");
                            final String figureurl_qq_2 = obj.getString("figureurl_qq_2");
                            @SuppressLint("SimpleDateFormat")
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                            String nowYear = sdf.format(new Date());
                            // year = nowYear - year;
                            int s = Integer.parseInt(nowYear) - Integer.parseInt(year);

                            final String age = String.valueOf(s);


                            Log.i("nickname>>>", nickname);
                            Log.i("figureurl_qq_1>>>", figureurl_qq_1 + "");
                            Log.i("figureurl_qq_2>>>", figureurl_qq_2 + "");

                            //final String sqlString = "select favorite_teacher from user_table where qq_openid=?";

                            new Thread() {
                                @Override
                                public void run() {

                                    //保存QQ登录用户信息到用户表
                                    String sql = "insert into user_table(username,sex,age,qq_openid,favorite_teacher) values (?,?,?,?,?)";
                                    Object[] objects = new Object[]{nickname, sex, age, openID, "{\"data\":[]}"};
                                    DBHelper.Update(sql,objects);

                                }
                            }.start();

                            new Thread(){
                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    String sqlString = "select favorite_teacher from user_table where qq_openid=?";

                                    List<HashMap<String, Object>> list = DBHelper.getList(sqlString, new Object[]{openID});
                                    for (HashMap<String, Object> map : list) {
                                        favorite_teacher_json = (String) map.get("favorite_teacher");
                                    }

                                    Log.i("favorite_teacher>>>>>>>>>>", favorite_teacher_json);

                                    SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("type", "2");// 2是QQ登录
                                    editor.putString("openId", openID);// id
                                    editor.putString("nickname", nickname); // 昵称
                                    editor.putString("sex", sex); //性别
                                    editor.putString("age", age); //年龄
                                    editor.putString("favorite_teacher", favorite_teacher_json);
                                    if (figureurl_qq_2.equals("") || figureurl_qq_2 == null) {
                                        editor.putString("figureurl_qq_1", figureurl_qq_2);
                                    } else {
                                        editor.putString("figureurl_qq_2", figureurl_qq_2);
                                    }
                                    editor.apply();
                                }
                            }.start();


                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            mTencent.logout(LoginActivity.this);
                            LoginActivity.this.finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(UiError uiError) {

                        Log.i("TAG", "登录失败" + uiError.toString());

                    }

                    @Override

                    public void onCancel() {

                        Log.i("TAG", "登录取消");

                    }

                });

            } catch (JSONException e) {

                e.printStackTrace();

            }

        }

        @Override

        public void onError(UiError uiError) {

            Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override

        public void onCancel() {

            Toast.makeText(LoginActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    private boolean isFirst;//是否第一次进入
    private SharedPreferences sp;//数据储存
    private Dialog dialog;

    //自定义对话框
    private void showDialog() {
        // 构建dialog显示的view布局
        View view = getLayoutInflater().from(this).inflate(R.layout.user_agreement_layout, null);
        //绑定该布局下的控件
        TextView tv1 = view.findViewById(R.id.tv_1);
        TextView tv_cancel = view.findViewById(R.id.tv_cancel);
        TextView tv1_agree = view.findViewById(R.id.tv_agree);
        if (dialog == null) {
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
                    "尤其是:1.我们对您的个人信息的收集、保存、使用、对外提供、保护等规则条款，以及您的用户权利等条款; " +
                    "2. 约定我们的限制责任、免责条款; 3.其他以颜色或加粗进行标识的重要条款。您点击“同意并继续”的行为即表示您已阅读完毕并同意以上协议的全部内容。" +
                    "如您同意以上协议内容，请点击“同意并继续”，开始使用我们的产品和服务!";


            final int star = str.indexOf("《");//最后一个出现的位置
            final int end = str.lastIndexOf("《");//最后一个出现的位置

            SpannableStringBuilder spannableString = new SpannableStringBuilder();
            spannableString.append(str);
            ClickableSpan clickableSpanpvy = new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    Log.i("ssssssssssss", "ces");
                }

                public void updateDrawState(TextPaint ds) {
                    /**set textColor**/
                    ds.setColor(ds.linkColor);
                    /**Remove the underline**/
                    ds.setUnderlineText(false);
                }
            };

            //点击隐私
            spannableString.setSpan(clickableSpanpvy, star, star + 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);


            ClickableSpan clickableSpanpcy = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    Toast.makeText(LoginActivity.this, "测试2", Toast.LENGTH_SHORT).show();

                }

                public void updateDrawState(TextPaint ds) {
                    /**set textColor**/
                    ds.setColor(ds.linkColor);
                    /**Remove the underline**/
                    ds.setUnderlineText(false);
                }
            };
            //点击用户协议
            spannableString.setSpan(clickableSpanpcy, end, end + 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#03A9F4"));

            spannableString.setSpan(colorSpan, star, star + 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            spannableString.setSpan(colorSpan, end, end + 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
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
                    sp = getSharedPreferences("one", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFrist", false);
                    editor.commit();
                    dialog.cancel();
                }
            });
        } else {
            dialog.show();
        }

    }


}
