package com.m520it.www.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            //让这个activity支持共享元素动画
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.activity_main);
        share = (ImageView) findViewById(R.id.share);

    }
    public void gotoDetail(View view){
        shareElement2();
    }
    public void old(){
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in,R.anim.out);
    }

    public void makeCustomAnimation(){
        //指定跳转的方式
        ActivityOptionsCompat activityOptionsCompat =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.in,R.anim.out);
        Intent intent = new Intent(this,DetailActivity.class);
        //新的
        ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle());

    }

    public void makeScalUp(View view){
        //变大的View
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeScaleUpAnimation(view, //The View that the new activity is animating from
                        (int)view.getWidth()/2, (int)view.getHeight()/2, //拉伸开始的坐标
                        0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
        Intent intent = new Intent(this,DetailActivity.class);

        //新的跳转的方法 (固定的写法)
        ActivityCompat.startActivity(this, intent, options.toBundle());

    }

    public void makeThumbnailScaleUpAnimation(View view){
       Bitmap bitmap =  BitmapFactory.decodeResource(getResources(),R.drawable.a3);
        //距离View的偏移量
        ActivityOptionsCompat options = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(view,bitmap,500,0);
        Intent intent = new Intent(this,DetailActivity.class);

        //新的跳转的方法 (固定的写法)
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    public void shareElement(){
        //1 告诉系统那个View是共享动画的View
        //2 告诉系统那个View是共享动画的transionName <->相同
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,share,getString(R.string.name));

        Intent intent = new Intent(this,DetailActivity.class);

        //新的跳转的方法 (固定的写法)
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    public void shareElement2(){
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(findViewById(R.id.share),getString(R.string.name)),
                        Pair.create(findViewById(R.id.share2),getString(R.string.name2)));

        Intent intent = new Intent(this,DetailActivity.class);

        //新的跳转的方法 (固定的写法)
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
