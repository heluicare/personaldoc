package com.google.gooddoctor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gooddoctor.R;

public class RotateYLayout extends LinearLayout {
    private String a = "RotateYLayout";
    public ImageView b;
    public ImageView c;
    public int d;
    public int e;
    public int f = 400;
    public int g = 2000;
    private RotateYAnimation h;
    private RotateYAnimation i;
    private boolean j = false;
    public boolean k = false;
    private long l = 0;
    public Runnable m = new Runnable() {
        public void run() {
            RotateYLayout.this.d();
        }
    };

    public RotateYLayout(Context context) {
        super(context);
        a();
    }

    public RotateYLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RotateYLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.treasure_box_and_voice, this);
        this.b = (ImageView) findViewById(R.id.iv_treasure_box);
        this.c = (ImageView) findViewById(R.id.iv_search_voice);
        this.d = 45;
        this.e = 45;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void b() {
        if (this.k) {
            if (this.i != null) {
                this.i.cancel();
            }
            if (this.h != null) {
                this.h.cancel();
            }
            removeCallbacks(this.m);
            g();
            this.k = !this.k;
        }
    }

    public void c() {
        if (!this.k) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.l != 0) {
            String str = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() - this.l);
            sb.append(" ms");
            Log.d(str, sb.toString());
        }
        this.l = System.currentTimeMillis();
        if (this.h == null) {
            e();
            f();
        }
        if (this.h.hasStarted() && !this.h.hasEnded()) {
            return;
        }
        if (!this.i.hasStarted() || this.i.hasEnded()) {
            this.k = true;
            if (this.j) {
                startAnimation(this.h);
            } else {
                startAnimation(this.i);
            }
            this.j = true ^ this.j;
        }
    }

    private void e() {
        this.h = new RotateYAnimation(360.0f, 270.0f, (float) this.d, (float) this.e);
        this.h.setDuration((long) this.f);
        this.h.setInterpolator(new AccelerateInterpolator());
        this.h.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                RotateYLayout.this.c.setVisibility(8);
                RotateYLayout.this.b.setVisibility(0);
                RotateYAnimation rotateYAnimation = new RotateYAnimation(90.0f, 0.0f, (float) RotateYLayout.this.d, (float) RotateYLayout.this.e);
                rotateYAnimation.setDuration((long) RotateYLayout.this.f);
                rotateYAnimation.setInterpolator(new DecelerateInterpolator());
                RotateYLayout.this.startAnimation(rotateYAnimation);
                if (RotateYLayout.this.k) {
                    RotateYLayout.this.postDelayed(RotateYLayout.this.m, (long) (RotateYLayout.this.f + RotateYLayout.this.g));
                } else {
                    RotateYLayout.this.g();
                }
            }
        });
    }

    private void f() {
        this.i = new RotateYAnimation(360.0f, 270.0f, (float) this.d, (float) this.e);
        this.i.setDuration((long) this.f);
        this.i.setInterpolator(new AccelerateInterpolator());
        this.i.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                RotateYLayout.this.c.setVisibility(0);
                RotateYLayout.this.b.setVisibility(8);
                RotateYAnimation rotateYAnimation = new RotateYAnimation(90.0f, 0.0f, (float) RotateYLayout.this.d, (float) RotateYLayout.this.e);
                rotateYAnimation.setDuration((long) RotateYLayout.this.f);
                rotateYAnimation.setInterpolator(new DecelerateInterpolator());
                RotateYLayout.this.startAnimation(rotateYAnimation);
                if (RotateYLayout.this.k) {
                    RotateYLayout.this.postDelayed(RotateYLayout.this.m, (long) (RotateYLayout.this.f + RotateYLayout.this.g));
                } else {
                    RotateYLayout.this.g();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.c != null) {
            this.c.setVisibility(8);
        }
        if (this.b != null) {
            this.b.setVisibility(0);
        }
        this.j = false;
    }
}