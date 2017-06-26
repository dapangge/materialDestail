package com.m520it.www.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CollapsingToolbarLayout tool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tool = (CollapsingToolbarLayout) findViewById(R.id.tool);
        tool.setTitle("i am so handSome!!!");
    }
}
