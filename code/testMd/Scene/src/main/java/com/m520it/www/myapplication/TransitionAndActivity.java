package com.m520it.www.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;

import static android.R.transition.explode;

/**
 * Created by xmg on 2017/3/4.
 */

public class TransitionAndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            //1 跳转使用的transition
            Explode explode = new Explode();

//            Slide slide = new Slide(Gravity.RIGHT);
//            slide.setDuration(2000);
            //让我们的页面支持transition

            TransitionInflater inflater = TransitionInflater.from(this);
            Transition  transition = inflater.inflateTransition(R.transition.over);
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            //页面退出的tristion
            getWindow().setExitTransition(transition);
        }


        setContentView(R.layout.activity_and_transition);


    }

    public void explose(View view){
        Intent intent  = new Intent();
        intent.setClass(this,TestExploseActivity.class);
        //不能使用 startActivity(intent),使用旧的系统的过场动画
        //一定要使用这个ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());


    }
}
