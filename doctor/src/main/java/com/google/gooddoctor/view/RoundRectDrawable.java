package com.google.gooddoctor.view;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable extends Drawable {
    private static final double a = Math.cos(Math.toRadians(45.0d));
    private final Paint b;
    private final RectF c;
    private final Rect d;
    private float e;
    private float f;
    private boolean g = false;
    private boolean h = true;
    private ColorStateList i;
    private PorterDuffColorFilter j;
    private ColorStateList k;
    private Mode l = Mode.SRC_IN;

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.e = f2;
        this.b = new Paint(5);
        b(colorStateList);
        this.c = new RectF();
        this.d = new Rect();
    }

    private float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - a) * ((double) f3))) : f2 * 1.5f;
    }

    private float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - a) * ((double) f3))) : f2;
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.i = colorStateList;
        this.b.setColor(this.i.getColorForState(getState(), this.i.getDefaultColor()));
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, boolean z, boolean z2) {
        if (f2 != this.f || this.g != z || this.h != z2) {
            this.f = f2;
            this.g = z;
            this.h = z2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    public float a() {
        return this.f;
    }

    public void draw(@NonNull Canvas canvas) {
        boolean z;
        Paint paint = this.b;
        if (this.j == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.j);
            z = true;
        }
        canvas.drawRoundRect(this.c, this.e, this.e, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.d.set(rect);
        if (this.g) {
            float a2 = a(this.f, this.e, this.h);
            this.d.inset((int) Math.ceil((double) b(this.f, this.e, this.h)), (int) Math.ceil((double) a2));
            this.c.set(this.d);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    public void getOutline(@NonNull Outline outline) {
        outline.setRoundRect(this.d, this.e);
    }

    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public float b() {
        return this.e;
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        if (f2 != this.e) {
            this.e = f2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public ColorStateList c() {
        return this.i;
    }

    public void a(@Nullable ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.k = colorStateList;
        this.j = a(this.k, this.l);
        invalidateSelf();
    }

    public void setTintMode(@NonNull Mode mode) {
        this.l = mode;
        this.j = a(this.k, this.l);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.i.getColorForState(iArr, this.i.getDefaultColor());
        boolean z = colorForState != this.b.getColor();
        if (z) {
            this.b.setColor(colorForState);
        }
        if (this.k == null || this.l == null) {
            return z;
        }
        this.j = a(this.k, this.l);
        return true;
    }

    public boolean isStateful() {
        return (this.k != null && this.k.isStateful()) || (this.i != null && this.i.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
