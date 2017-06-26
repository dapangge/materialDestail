package com.m520it.www.circularreveal;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = (FrameLayout) findViewById(R.id.frame);
        //View 即将在这个view上面产生效果
        //centerX centerY 中心点的坐标
        //startRadius 动画的开始的半径
        //endRadius 动画的结束的半径
        //ViewAnimationUtils.createCircularReveal(View view,int centerX,int centerY,float startRadius, float endRadius)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void show_circle(View view) {
        Animator circle = ViewAnimationUtils.createCircularReveal(content, 0, 0, 0, 1000);
        content.setBackgroundColor(Color.BLUE);
        circle.setDuration(2000);
        circle.start();
    }
}
