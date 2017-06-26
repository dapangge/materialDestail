package com.m520it.www.testhandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    HandlerThread woker;
    Handler mHandler;
    Handler uiHandler;
    int[] darwables;
    ArrayList<ImageView> imageViews;
    ViewPager viewPager;
    TextView title;
    pagerAdper adper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        title = (TextView) findViewById(R.id.title);


        darwables = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
        imageViews = new ArrayList<>();
        for (int i = 0; i < darwables.length; i++) {
            ImageView image = new ImageView(this);
            //image.setBackgroundResource(darwables[i]);
            imageViews.add(image);
        }

        adper = new pagerAdper(imageViews, this);
        viewPager.setAdapter(adper);
        viewPager.addOnPageChangeListener(this);

//        mHandler = new Handler();//UI线程的looper
//        //将run()运行在looper的线程上面
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(25*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        //UI线程 -> 获取当前的线程的looper
        woker = new HandlerThread("worker"); //开启了一直存在
        woker.start();
        //mHandler绑定到woker子线程的looper上面
        mHandler = new Handler(woker.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==99){
                    title.setText("aaaaa");
                }else{
                    int index = msg.arg1;
                    //一定是在子线程
                    changeColor(index);
                }

            }
        };
        uiHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int color = msg.arg1;
                setMyTitleColor(color);
            }
        };

        readyTochang(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注意HandlerThread用完一定要退出,否则会造成线程泄漏
        woker.quit();
    }

    public void show(View view){
        mHandler.sendEmptyMessage(99);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        readyTochang(position);
    }

    public void readyTochang(int position){
        Message message = mHandler.obtainMessage();
        message.arg1 = position;
        mHandler.sendMessage(message);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void changeColor(int index) {
        Bitmap bm = BitmapFactory.decodeResource(getResources(), darwables[index]);
        Palette.from(bm).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                if (palette.getDarkMutedSwatch() != null) {

                    int color = palette.getDarkMutedSwatch().getRgb();

                    Message message = uiHandler.obtainMessage();
                    message.arg1 = color;
                    uiHandler.sendMessage(message);

                }else if(palette.getLightVibrantSwatch() != null){

                    int color = palette.getLightVibrantSwatch().getRgb();

                    Message message = uiHandler.obtainMessage();
                    message.arg1 = color;
                    uiHandler.sendMessage(message);
                }
            }
        });
    }

    public void setMyTitleColor(int color){
        title.setBackgroundColor(color);
        Window window = getWindow();
        if(Build.VERSION.SDK_INT>=21){
            window.setStatusBarColor(color);
            window.setNavigationBarColor(color);
        }

    }

    class pagerAdper extends PagerAdapter {
        ArrayList<ImageView> views;
        Context context;

        public pagerAdper(ArrayList<ImageView> views, Context context) {
            this.views = views;
            this.context = context;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = views.get(position);
            container.addView(imageView);
            return imageView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }
}
