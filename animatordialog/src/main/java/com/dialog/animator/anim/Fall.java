package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class Fall extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
        animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "scaleX", 2, 1.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",2,1.5f,1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)

            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "scaleX", 1, 1.5f, 2).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",1,1.5f,2).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2)

            );
        }
    }
}
