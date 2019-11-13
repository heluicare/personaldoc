package com.google.gooddoctor.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.gooddoctor.R;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class PtrAnimationHeader extends FrameLayout implements PtrUIHandler {

    private AnimationDrawable animationDrawable;
    private ImageView imageView;

    /**
     * 状态识别
     */
    private int mState;

    /**
     * 重置
     * 准备刷新
     * 开始刷新
     * 结束刷新
     */
    public static final int STATE_RESET = -1;
    public static final int STATE_PREPARE = 0;
    public static final int STATE_BEGIN = 1;
    public static final int STATE_FINISH = 2;


    public PtrAnimationHeader(Context context) {
        super(context);
        initView();
    }

    public PtrAnimationHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PtrAnimationHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.ptr_header_view, this, false);
        imageView = (ImageView) view.findViewById(R.id.animation);
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        addView(view);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {
        mState = STATE_RESET;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState = STATE_PREPARE;
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        mState = STATE_BEGIN;
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        mState = STATE_FINISH;
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        //处理提醒字体
        switch (mState) {
            case STATE_PREPARE:
                if (ptrIndicator.getCurrentPercent() < 1) {
                    //下拉刷新
                    Log.i("hel->", "下拉刷新...");
                } else {
                    //松开立即刷新
                    Log.i("hel->", "松开立即刷新...");
                }
                if(animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                break;
            case STATE_BEGIN:
                //正在刷新
                if(!animationDrawable.isRunning()) {
                    animationDrawable.start();
                }
                Log.i("hel->", "正在刷新...");
                break;
            case STATE_FINISH:
                //加载完成
                if(animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                Log.i("hel->", "加载完成...");
                break;
        }
    }

}
