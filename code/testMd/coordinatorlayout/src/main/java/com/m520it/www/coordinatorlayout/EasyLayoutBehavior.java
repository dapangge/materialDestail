package com.m520it.www.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by xmg on 2017/3/3.
 */
                                                                   //fl同学
public class EasyLayoutBehavior extends CoordinatorLayout.Behavior<TextView> {

    //注意一定要实现空的构造方法
    public EasyLayoutBehavior() {
    }

    public EasyLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


//告诉Coordinlayoutt

    //判断一下dependency是不是jk同学
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof ImageView;
    }


    //当被观察的控件发生变化的时候触发
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
       float x =  dependency.getX();
       float y = dependency.getY();
        child.setX(x);
        child.setY(y+ dependency.getHeight()+10);
        child.setText("x = "+x+" y = "+(y+ dependency.getHeight()+10));
        return true;
    }
}
