package com.edu.edusystem.tools;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

public class MyStyle {
    public MyStyle(Activity activity, int color_id){
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity, color_id));


    }
}
