package com.dialog.animator.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class NewsPaper extends BaseAnimator {

    @Override
    protected void setupAnimation(View view) {
       animation(view);
    }

    private void  animation(View view){
        if(isShow){
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotation", 1080,720,360,0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2),
                    ObjectAnimator.ofFloat(view, "scaleX", 0.1f, 0.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",0.1f,0.5f,1).setDuration(mDuration)
            );
        }else{
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(view, "rotation", 0,360,720,1080).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2),
                    ObjectAnimator.ofFloat(view, "scaleX", 1, 0.5f, 0.1f).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view,"scaleY",1,0.5f,0.1f).setDuration(mDuration)
            );
        }
    }
}
