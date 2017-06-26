package com.m520it.www.circularreveal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by xmg on 2017/3/4.
 */

public class RoundToolBarActivity extends AppCompatActivity {
    ImageView share;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_round_toolbar);
        share = (ImageView) findViewById(R.id.share);
    }

    public void gotoDetail(View view){
        Intent intent = new Intent();
        intent.setClass(this,RoundToolBarDetailActivity.class);

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,share,getString(R.string.name));

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
