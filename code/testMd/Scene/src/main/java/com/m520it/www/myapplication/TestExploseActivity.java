package com.m520it.www.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;

import java.util.ArrayList;

/**
 * Created by xmg on 2017/3/4.
 */

public class TestExploseActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<String> titles;

    RecyAdapter mRecyAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Slide slide = new Slide(Gravity.BOTTOM);
//        slide.setDuration(1000);
//        //这句话一定要加
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setEnterTransition(slide);

        setContentView(R.layout.activity_test_explose);
        recyclerView = (RecyclerView) findViewById(R.id.recyle);

        titles = new ArrayList<>();
        for(int i =0;i<100;i++){
            titles.add(String.valueOf(i));
        }

        mRecyAdapter = new RecyAdapter(titles);
        //以表格的形式展示内容,4个一行
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(mRecyAdapter);
        mRecyAdapter.setListener(new OnItemClickListener() {
            @Override
            public void clickedItem() {
                //指定了一个爆炸动画
                Explode explode = new Explode();
                explode.setDuration(1000);

//                Slide slide  = new Slide(Gravity.RIGHT);
//                slide.setDuration(2000);
//
//                Fade fade = new Fade();
//                fade.setDuration(2000);

//                开启了一个监控的
                TransitionManager.beginDelayedTransition(recyclerView,explode);
                recyclerView.setAdapter(null);
                //recyclerView.setVisibility(View.GONE);
            }
        });
    }
}
