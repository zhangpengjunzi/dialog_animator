package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;


public class SlideBottom extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
        animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "translationY", 300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)
            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "translationY", 0, 300).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2)
            );
        }
    }
}
