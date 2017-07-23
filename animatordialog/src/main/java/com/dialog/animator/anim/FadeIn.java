package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;


public class FadeIn extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
        animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view,"alpha",0,1).setDuration(mDuration)

            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view,"alpha",1,0).setDuration(mDuration)

            );
        }
    }
}
