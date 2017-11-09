package com.lonelyyhu.exercise.animationsample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button startBtn1;
    private Button startBtn2;

    private Button endBtn;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn1 = (Button) findViewById(R.id.btn_start1);
        startBtn1.setOnClickListener(this);

        startBtn2 = (Button) findViewById(R.id.btn_start2);
        startBtn2.setOnClickListener(this);

        endBtn = (Button) findViewById(R.id.btn_end);
        endBtn.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.iv1);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_start1:
                showAnimation();
                break;

            case R.id.btn_start2:
                showAnimation3();
                break;

            case R.id.btn_end:
                imageView.clearAnimation();
                break;

        }


    }

    private void showAnimation() {
        SwingAnimation swingAnimation = new SwingAnimation();

        swingAnimation.setDuration(2000);

        swingAnimation.setSwingCount(2);

        swingAnimation.setInterpolator(new LinearInterpolator());

        imageView.startAnimation(swingAnimation);
    }

    private void showAnimation2() {
        Animation am = new RotateAnimation(0, 30, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        Animation am1 = new RotateAnimation(30, -30, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        Animation am2 = new RotateAnimation(-30, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);

        // 動畫開始到結束的執行時間 (1000 = 1 秒)
        am.setDuration(250);
        am1.setDuration(500);
        am2.setDuration(250);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(am);
        animationSet.addAnimation(am1);
        animationSet.addAnimation(am2);

//        animationSet.setRepeatCount(2);
//        animationSet.setDuration(1000);

        imageView.startAnimation(animationSet);
    }

    private void showAnimation3() {
        imageView.setPivotX(imageView.getWidth()/2);
        imageView.setPivotY(imageView.getHeight());

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotation",0, 12);
        animator.setDuration(250);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView,"rotation",12, -12);
        animator1.setDuration(500);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView,"rotation", -12, 12);
        animator2.setDuration(500);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView,"rotation", 12, -12);
        animator3.setDuration(500);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView,"rotation", -12, 0);
        animator4.setDuration(250);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(
                animator,animator1,animator2,animator3,animator4
        );

        animatorSet.start();

    }
}
