package com.lonelyyhu.exercise.animationsample;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by hulonelyy on 2017/11/8.
 */

public class SwingAnimation extends Animation{

    private int mWidth;
    private int mHeight;
    private int swingCount = 1;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        this.mWidth = width;
        this.mHeight = height;
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        // 左右摇摆
        t.getMatrix().setRotate((float)(Math.sin(interpolatedTime * Math.PI * 2 * swingCount) * 12), mWidth/2, mHeight);
        super.applyTransformation(interpolatedTime, t);
    }

    public void setSwingCount(int count) {
        this.swingCount = count;
    }
}
