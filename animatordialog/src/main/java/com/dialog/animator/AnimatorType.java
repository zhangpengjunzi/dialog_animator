package com.dialog.animator;

import com.dialog.animator.anim.BaseAnimator;
import com.dialog.animator.anim.FadeIn;
import com.dialog.animator.anim.Fall;
import com.dialog.animator.anim.FlipH;
import com.dialog.animator.anim.FlipV;
import com.dialog.animator.anim.NewsPaper;
import com.dialog.animator.anim.RotateBottom;
import com.dialog.animator.anim.RotateLeft;
import com.dialog.animator.anim.Shake;
import com.dialog.animator.anim.SideFall;
import com.dialog.animator.anim.SlideBottom;
import com.dialog.animator.anim.SlideLeft;
import com.dialog.animator.anim.SlideRight;
import com.dialog.animator.anim.SlideTop;
import com.dialog.animator.anim.Slit;

public enum AnimatorType {

    Fadein(FadeIn.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    Slideright(SlideRight.class),
    Fall(Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    Slit(Slit.class),
    Shake(Shake.class),
    Sidefill(SideFall.class);
    private Class<? extends BaseAnimator> effectsClazz;

    private AnimatorType(Class<? extends BaseAnimator> mclass) {
        effectsClazz = mclass;
    }

    public BaseAnimator getAnimator() {
        BaseAnimator bEffects=null;
	try {
		bEffects = effectsClazz.newInstance();
	} catch (ClassCastException e) {
		throw new Error("Can not init animatorClazz instance");
	} catch (InstantiationException e) {
		throw new Error("Can not init animatorClazz instance");
	} catch (IllegalAccessException e) {
		throw new Error("Can not init animatorClazz instance");
	}
	return bEffects;
    }
}
