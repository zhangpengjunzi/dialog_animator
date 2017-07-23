package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;


public class FlipV extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
       animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationX", -90, 0).setDuration(mDuration)

            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationX", 0, -90).setDuration(mDuration)

            );
        }
    }
}
