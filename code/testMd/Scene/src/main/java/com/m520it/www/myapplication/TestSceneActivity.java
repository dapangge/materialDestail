package com.m520it.www.myapplication;

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

public class TestSceneActivity extends AppCompatActivity {
    RelativeLayout content;
    Scene one;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_testscene);
        content = (RelativeLayout) findViewById(R.id.content);

        one = Scene.getSceneForLayout(content,R.layout.one,this);


    }

    public void gotoOne(View view){
        TransitionManager.go(one,new ChangeBounds());
    }
}
