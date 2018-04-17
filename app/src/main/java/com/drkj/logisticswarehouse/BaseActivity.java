package com.drkj.logisticswarehouse;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * Created by ganlong on 2017/10/10.
 */

public class BaseActivity extends Activity {

    protected static Stack<Activity> activities;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (activities == null) {
            activities = new Stack();
        }
        activities.add(this);
    }

    protected void startActivity(Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
            activity.finish();
        }
    }

    public void finishActivity(Class<?> cls) {
        Iterator var1 = activities.iterator();

        while (var1.hasNext()) {
            Activity activity = (Activity) var1.next();
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }
}
