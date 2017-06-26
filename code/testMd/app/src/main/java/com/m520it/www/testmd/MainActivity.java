package com.m520it.www.testmd;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);


        //做好版本适配
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(Color.RED);
            getWindow().setStatusBarColor(Color.GREEN);
        }

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setTranslationZ(200f);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setTranslationZ(0f);
                        }
                        break;
                }
                return true;
            }
        });
    }
}
