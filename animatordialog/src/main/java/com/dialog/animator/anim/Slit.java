package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;


public class Slit extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
       animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 90,88,88,45,0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0,0.4f,0.8f, 1).setDuration(mDuration*3/2),
                    ObjectAnimator.ofFloat(view, "scaleX", 0,0.5f, 0.9f, 0.9f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",0,0.5f, 0.9f, 0.9f, 1).setDuration(mDuration)
            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 0,45,88,88,90).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1,0.8f,0.4f,0).setDuration(mDuration*3/2),
                    ObjectAnimator.ofFloat(view, "scaleX", 1,0.9f, 0.9f, 0.5f,0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",1,0.9f, 0.9f, 0.5f,0).setDuration(mDuration)
            );
        }
    }
}
