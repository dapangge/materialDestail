package com.m520it.www.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by xmg on 2017/3/3.
 */

public class TestBehaviorActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_behavior);
        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE :
                        float x =  motionEvent.getRawX();
                        float y =  motionEvent.getRawY();
                        img.setX(x);
                        img.setY(y);
                        break;
                }
                return true;
            }
        });
    }
}
