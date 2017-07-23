package com.dialog.animator;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.dialog.animator.anim.BaseAnimator;

/**
 * Created by user on 2017/7/22.
 * @author  张鹏
 */

public abstract class AnimatorBaseDialog extends Dialog {

    //需要加载的资源文件，同时用来加载动画
    private View contentView;
    //Window对象
    private Window window;
    //window属性数组,3个元素。第一个是窗体位置，第二个是窗体宽度，第三个是窗体高度
    private int [] winProperty={Gravity.CENTER,
            ViewGroup.LayoutParams.MATCH_PARENT};
    //动画执行时间
    private int mDuration=-1;
    //是否开启动画
    private boolean isShouldStartAnimation=true;
    //选择动画,默认淡入淡出
    private AnimatorType animatorType= AnimatorType.Fadein;
    //动画类
    private BaseAnimator baseAnimator;
    //父容器，点击让dialog小时
    private LinearLayout base_linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public AnimatorBaseDialog(Context context) {
        super(context);
        init(context);
    }

    public AnimatorBaseDialog(Context context,int themeResId) {
        super(context, themeResId);
        init(context);
    }

    //Dialog内容
    public abstract int contentView();
    //设置窗体属性
    public abstract int [] SetWindow();
    //是否可以点击取消
    public abstract boolean dialogCanCancle();
    //需要在隐藏和显示监听里面写逻辑的话可以重写以下方法
    protected void addShowListener(){}
    protected void addDismissListener(){}

    //初始化窗口
    private  void init(final Context context){
        contentView=View.inflate(context,contentView(),null);
        setContentView(R.layout.layout_dialog);
        //将自己的dialog添加到viewgroup中
        ((FrameLayout)findViewById(R.id.parent_view)).addView(contentView);
        //点击让dialog消失
        base_linear= (LinearLayout) findViewById(R.id.parent);
        base_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(false);
                //动画结束后让dialog消失
                new Handler(context.getMainLooper()).postDelayed(new Runnable(){
                    public void run() {
                        dismiss();
                    }
                }, mDuration);
            }
        });
        //设置窗体属性
        if(SetWindow()!=null){
            winProperty=SetWindow();
        }
        window=getWindow();
        //设置窗体位置和大小
        window.setGravity(winProperty[0]);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width=winProperty[1];
        wl.height=ViewGroup.LayoutParams.MATCH_PARENT;
        setCancelable(dialogCanCancle());
        //显示监听
        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                if(isShouldStartAnimation){
                    start(true);
                }
                //动画结束后可以点击
                new Handler(context.getMainLooper()).postDelayed(new Runnable(){
                    public void run() {
                        base_linear.setClickable(true);
                    }
                }, mDuration);
                addShowListener();
            }
        });
        //隐藏监听
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if(isShouldStartAnimation){
                    start(false);
                }
                addDismissListener();
            }
        });
    }


    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }


    public void setShouldStartAnimation(boolean shouldStartAnimation) {
        isShouldStartAnimation = shouldStartAnimation;
    }


    public void setAnimatorType(AnimatorType animatorType) {
        this.animatorType = animatorType;
    }

    private  void start(boolean show){
        if(baseAnimator==null){
            baseAnimator=animatorType.getAnimator();
            if(mDuration!=-1){
                baseAnimator.setDuration(mDuration);
            }
        }
        base_linear.setClickable(false);
        baseAnimator.start(window.getDecorView(),show);
    }
}
