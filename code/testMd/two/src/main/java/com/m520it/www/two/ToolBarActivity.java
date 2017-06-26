package com.m520it.www.two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by xmg on 2017/3/3.
 */

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView img;
    private Button btn;
    private EditText edt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn = (Button) findViewById(R.id.btn);


        toolbar.setTitle("handSome");
        toolbar.setSubtitle("beautiflly");
        toolbar.setLogo(R.mipmap.ic_launcher);
    }

    public void show_toast(View view) {
        //Toast.makeText(this,"i am a toast!!!",Toast.LENGTH_SHORT).show();
        //view 从这个控件进行寻找,找到最根部的控件
        //显示长度有三个 1长 2 短 3 无限
        Snackbar bar = Snackbar.make(view, "看直播请登录,充值!!!", Snackbar.LENGTH_LONG);
        bar.setAction("请充值", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("it520","被点击了!!!");
            }
        });
        bar.show();
    }


}
