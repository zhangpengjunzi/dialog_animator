package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class Shake  extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
       animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "translationX", 0, .10f, -25, .26f, 25,.42f, -25, .58f, 25,.74f,-25,.90f,1,0).setDuration(mDuration)
            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "translationY", 0, 300).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2)
            );
        }
    }
}
