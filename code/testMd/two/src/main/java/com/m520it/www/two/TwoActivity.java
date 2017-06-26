package com.m520it.www.two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xmg on 2017/3/3.
 */

public class TwoActivity extends AppCompatActivity {

   // @去查找相应的资源文件
   // ?android:attr/selectableItemBackground 系统的样式下面查找selectableItemBackground
   // ?attr/colorText 当前的应用下面的样式去查找colorText

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }
}
