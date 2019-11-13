package com.google.gooddoctor.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;

import com.google.gooddoctor.util.DisplayUtil;

public class RotateImageView extends AppCompatImageView {
    private String a = "RotateYLayout";
    private int b;
    private int c;
    private int d = 1000;
    public int e = 2000;
    private RotateYAnimation f;
    public boolean g = false;
    private long h = 0;
    public Runnable i = new Runnable() {
        public void run() {
            RotateImageView.this.d();
        }
    };

    public RotateImageView(Context context) {
        super(context);
        a();
    }

    public RotateImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RotateImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public void a() {
        this.b = DisplayUtil.a(getContext(), 30.0f) / 2;
        this.c = DisplayUtil.a(getContext(), 36.0f) / 2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public void b() {
        if (this.g) {
            this.g = false;
            if (this.f != null) {
                this.f.cancel();
            }
        } else {
            setVisibility(View.GONE);
        }
        removeCallbacks(this.i);
    }

    public void c() {
        if (!this.g) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        setVisibility(View.VISIBLE);
        if (this.h != 0) {
            String str = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() - this.h);
            sb.append(" ms");
            Log.d(str, sb.toString());
        }
        this.h = System.currentTimeMillis();
        if (this.f == null) {
            e();
        }
        if (!this.f.hasStarted() || this.f.hasEnded()) {
            this.g = true;
            startAnimation(this.f);
        }
    }

    private void e() {
        this.f = new RotateYAnimation(360.0f, 270.0f, (float) this.b, (float) this.c);
        this.f.setDuration((long) this.d);
        this.f.setRepeatMode(2);
        this.f.setRepeatCount(3);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (RotateImageView.this.g) {
                    RotateImageView.this.g = false;
                    RotateImageView.this.postDelayed(RotateImageView.this.i, (long) RotateImageView.this.e);
                    return;
                }
                RotateImageView.this.setVisibility(View.GONE);
            }
        });
    }
}