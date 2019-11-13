package com.google.gooddoctor.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.google.gooddoctor.R;

public class CardView extends FrameLayout {
    private static final int[] e = {16842801};
    private static final CardViewImpl f;
    final Rect a;
    final Rect b;
    int c;
    int d;
    private boolean g;
    private boolean h;
    private final CardViewDelegate i;

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f = new CardViewApi21Impl();
        } else if (VERSION.SDK_INT >= 17) {
            f = new CardViewApi17Impl();
        } else {
            f = new CardViewBaseImpl();
        }
        f.a();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        this.a = new Rect();
        this.b = new Rect();
        this.i = new CardViewDelegate() {
            private Drawable b;

            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            public void a(int i, int i2, int i3, int i4) {
                CardView.this.b.set(i, i2, i3, i4);
                CardView.super.setPadding(i + CardView.this.a.left, i2 + CardView.this.a.top, i3 + CardView.this.a.right, i4 + CardView.this.a.bottom);
            }

            public void a(int i, int i2) {
                if (i > CardView.this.c) {
                    CardView.super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.d) {
                    CardView.super.setMinimumHeight(i2);
                }
            }

            public Drawable c() {
                return this.b;
            }

            public void a(Drawable drawable) {
                this.b = drawable;
                CardView.this.setBackground(drawable);
            }

            public View d() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i3 = getResources().getColor(R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardShadowColorStart);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardShadowColorEnd);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.g = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.h = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        this.a.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.a.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.a.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.a.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f.a(this.i, context, colorStateList, dimension, dimension2, f2, colorStateList2, colorStateList3);
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            f.g(this.i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(f instanceof CardViewApi21Impl)) {
            int mode = MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || (mode != 0 && mode == 1073741824)) {
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f.b(this.i)), MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || (mode2 != 0 && mode2 == 1073741824)) {
                i3 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f.c(this.i)), MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setMinimumWidth(int i2) {
        this.c = i2;
        super.setMinimumWidth(i2);
    }

    public void setMinimumHeight(int i2) {
        this.d = i2;
        super.setMinimumHeight(i2);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        f.a(this.i, ColorStateList.valueOf(i2));
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f.i(this.i);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f.a(this.i, colorStateList);
    }

    public int getContentPaddingLeft() {
        return this.a.left;
    }

    public int getContentPaddingRight() {
        return this.a.right;
    }

    public int getContentPaddingTop() {
        return this.a.top;
    }

    public int getContentPaddingBottom() {
        return this.a.bottom;
    }

    public float getRadius() {
        return f.d(this.i);
    }

    public void setRadius(float f2) {
        f.a(this.i, f2);
    }

    public float getCardElevation() {
        return f.e(this.i);
    }

    public void setCardElevation(float f2) {
        f.c(this.i, f2);
    }

    public float getMaxCardElevation() {
        return f.a(this.i);
    }

    public void setMaxCardElevation(float f2) {
        f.b(this.i, f2);
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            f.h(this.i);
        }
    }
}
