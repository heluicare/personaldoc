package com.google.gooddoctor.view;

import android.content.Context;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SpringScrollView extends NestedScrollView {

    private float a;
    private SpringAnimation b;
    private SpringAnimation c;
    private ScrollViewListener d;
    private View e;
    private int f;

    public interface ScrollViewListener {
        void a(SpringScrollView springScrollView, int i, int i2, int i3, int i4);
    }

    public SpringScrollView(Context context) {
        this(context, null);
    }

    public SpringScrollView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpringScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = null;
        this.f = 0;
        this.b = new SpringAnimation(this, SpringAnimation.TRANSLATION_Y, 0.0f);
        this.b.getSpring().setStiffness(1000.0f);
        this.b.getSpring().setDampingRatio(2.0f);
    }

    public void setView(View view) {
        this.e = view;
        if (this.c == null && view != null) {
            this.c = new SpringAnimation(this.e, SpringAnimation.SCALE_Y, 1.0f);
            this.c.getSpring().setStiffness(1000.0f);
            this.c.getSpring().setDampingRatio(2.0f);
        }
    }

    public void setheight(int i) {
        this.f = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (getTranslationY() != 0.0f) {
                    this.b.start();
                    if (this.c != null) {
                        this.c.start();
                    }
                }
                this.a = 0.0f;
                break;
            case 2:
                if (getScrollY() > 0 && getScrollY() + getHeight() >= getChildAt(0).getMeasuredHeight()) {
                    if (this.a == 0.0f) {
                        this.a = motionEvent.getRawY();
                    }
                    if (motionEvent.getRawY() - this.a > 0.0f) {
                        this.a = 0.0f;
                        this.b.cancel();
                        if (this.c != null) {
                            this.c.cancel();
                        }
                        setTranslationY(0.0f);
                        if (this.e != null) {
                            this.e.setScaleY(1.0f);
                            break;
                        }
                    } else {
                        setTranslationY((motionEvent.getRawY() - this.a) / 3.0f);
                        if (this.e != null) {
                            this.e.getY();
                            float rawY = (motionEvent.getRawY() - this.a) / 2.0f;
                            if (this.f != 0) {
                                this.e.setScaleY(1.0f + (rawY / ((float) this.f)));
                            }
                        }
                        return true;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.d = scrollViewListener;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.d != null) {
            this.d.a(this, i, i2, i3, i4);
        }
    }

}