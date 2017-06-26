package com.m520it.www.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by xmg on 2017/3/3.
 */

public class ShowTopBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {

    public ShowTopBehavior() {
    }

    public ShowTopBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        float y = dependency.getY();
        int height = child.getHeight();
        if(y<=height){
           //显示图片
            child.findViewById(R.id.top_img).setVisibility(View.VISIBLE);
        }
        else{
           //隐藏图片
            child.findViewById(R.id.top_img).setVisibility(View.GONE);
        }
        return true;
    }
}
