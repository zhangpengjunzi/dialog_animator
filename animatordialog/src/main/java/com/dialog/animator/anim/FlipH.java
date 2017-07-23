package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class FlipH  extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
       animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", -90, 0).setDuration(mDuration)

            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 0,-90).setDuration(mDuration)
            );
        }
    }
}
