package com.google.gooddoctor.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ViewAnimator;

public class JKViewFlipper extends ViewAnimator {
    public int a;
    private boolean b;
    public boolean c;
    public final Runnable d;

    public JKViewFlipper(Context context) {
        super(context);
        this.a = 3000;
        this.b = false;
        this.c = false;
        this.d = new Runnable() {
            public void run() {
                if (JKViewFlipper.this.c) {
                    JKViewFlipper.this.showNext();
                    JKViewFlipper.this.postDelayed(JKViewFlipper.this.d, (long) JKViewFlipper.this.a);
                }
            }
        };
    }

    public JKViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 3000;
        this.b = false;
        this.c = false;
        this.d = new Runnable() {
            public void run() {
                if (JKViewFlipper.this.c) {
                    JKViewFlipper.this.showNext();
                    JKViewFlipper.this.postDelayed(JKViewFlipper.this.d, (long) JKViewFlipper.this.a);
                }
            }
        };
        this.a = 3000;
        this.b = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b) {
            a();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            Log.i("JKViewFlipper", "onVisibilityChanged - 前台");
        } else {
            Log.i("JKViewFlipper", "onVisibilityChanged - 后台");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchVisibilityChanged(View view, int i) {
        super.dispatchVisibilityChanged(view, i);
        if (i == 0) {
            Log.i("JKViewFlipper", "dispatchVisibilityChanged - 前台");
        } else {
            Log.i("JKViewFlipper", "dispatchVisibilityChanged - 后台");
        }
    }

    public void setFlipInterval(int i) {
        this.a = i;
        StringBuilder sb = new StringBuilder();
        sb.append("setFlipInterval -- 设置间隙时间 ");
        sb.append(i);
        Log.i("JKViewFlipper", sb.toString());
    }

    public void a() {
        Log.i("JKViewFlipper", "startFlipping -- 启动");
        this.c = true;
        if (this.b) {
            postDelayed(this.d, (long) this.a);
        }
    }

    public void b() {
        Log.i("JKViewFlipper", "stopFlipping -- 停止");
        this.c = false;
        if (this.d != null) {
            removeCallbacks(this.d);
        }
    }

    public boolean c() {
        return this.c;
    }

    public CharSequence getAccessibilityClassName() {
        return JKViewFlipper.class.getName();
    }

    public void setAutoStart(boolean z) {
        this.b = z;
        StringBuilder sb = new StringBuilder();
        sb.append("setAutoStart -- 设置自动播放 - ");
        sb.append(z);
        Log.i("JKViewFlipper", sb.toString());
    }
}