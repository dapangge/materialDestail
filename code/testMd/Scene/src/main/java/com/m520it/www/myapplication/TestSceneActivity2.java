package com.m520it.www.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

/**
 * Created by xmg on 2017/3/4.
 */

public class TestSceneActivity2 extends AppCompatActivity {
    RelativeLayout content;
    Scene one;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_testscene2);
        content = (RelativeLayout) findViewById(R.id.content);

        if(Build.VERSION.SDK_INT>=19){
            one = Scene.getSceneForLayout(content, R.layout.activity_testscene3,this);
        }



    }

    public void gotoOne(View view){

        if(Build.VERSION.SDK_INT>=19){
            //位移动画,位移动画的执行时间为2秒
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(2000);
            TransitionManager.go(one,changeBounds);
        }

    }
}
