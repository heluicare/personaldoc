package com.google.gooddoctor.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.gooddoctor.R;

public class RadioGroupTabLine extends RadioGroup {
    public OnCheckedChangeListener a;
    Animator b;
    private int c;
    private int d;
    private Paint e;
    public int f;
    public int g;
    public boolean h = false;
    private OnCheckedChangeListener i = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1) {
                RadioButton radioButton = (RadioButton) RadioGroupTabLine.this.findViewById(i);
                if (RadioGroupTabLine.this.h) {
                    if (RadioGroupTabLine.this.b != null) {
                        RadioGroupTabLine.this.b.cancel();
                    }
                    RadioGroupTabLine.this.b = ObjectAnimator.ofPropertyValuesHolder(RadioGroupTabLine.this, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("IndicatorLeft", new int[]{RadioGroupTabLine.this.f, radioButton.getLeft()}), PropertyValuesHolder.ofInt("IndicatorRight", new int[]{RadioGroupTabLine.this.g, radioButton.getRight()})});
                    RadioGroupTabLine.this.b.setDuration(250);
                    RadioGroupTabLine.this.b.setInterpolator(new FastOutSlowInInterpolator());
                    RadioGroupTabLine.this.b.start();
                } else {
                    RadioGroupTabLine.this.setIndicatorLeft(radioButton.getLeft());
                    RadioGroupTabLine.this.setIndicatorRight(radioButton.getRight());
                }
            }
            if (RadioGroupTabLine.this.a != null) {
                RadioGroupTabLine.this.a.onCheckedChanged(radioGroup, i);
            }
        }
    };

    public RadioGroupTabLine(Context context) {
        super(context);
    }

    public RadioGroupTabLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadioGroupTabLine, 0, 0);
        this.c = obtainStyledAttributes.getColor(0, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.e = new Paint();
        this.e.setColor(this.c);
        super.setOnCheckedChangeListener(this.i);
        setWillNotDraw(false);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.a = onCheckedChangeListener;
    }

    public void setAnimation(boolean z) {
        this.h = z;
    }

    public void setIndicatorLeft(int i2) {
        this.f = i2;
        invalidate();
    }

    public void setIndicatorRight(int i2) {
        this.g = i2;
        invalidate();
    }
}
