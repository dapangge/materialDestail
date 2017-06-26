package com.m520it.www.circularreveal;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;

/**
 * Created by xmg on 2017/3/4.
 */

public class RoundToolBarDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            ChangeBounds changeBounds = new ChangeBounds();
            //开启transition
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setSharedElementEnterTransition(changeBounds);
            //监听过场动画
            changeBounds.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onTransitionEnd(Transition transition) {
                    showAnimation();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        }

        setContentView(R.layout.activity_round_toolbar_detail);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showAnimation(){
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
         int centerX = (toolbar.getLeft()+toolbar.getRight())/2;
         int centery = (toolbar.getTop()+toolbar.getBottom())/2;
         float f_s = Math.max(toolbar.getWidth(),toolbar.getHeight());
         Animator animator = ViewAnimationUtils.createCircularReveal(toolbar,centerX,centery,0,f_s);
         toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
         animator.start();
    }

    public void gotoDetail(View view){

    }
}
