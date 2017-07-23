package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class RotateLeft extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
        animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 90, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "translationX", -300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)

            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 0, 90).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "translationX",0, -300).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2)

            );
        }
    }
}
