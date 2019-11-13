package com.google.gooddoctor.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PixelFormat;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gooddoctor.R;

class RoundRectDrawableWithShadow extends Drawable {
    static RoundRectHelper a;
    private static final double b = Math.cos(Math.toRadians(45.0d));
    private final int c;
    private final RectF d;
    private ColorStateList e;
    private ColorStateList f;
    private Paint g;
    private Paint h;
    private Paint i;
    private float j;
    private Path k;
    private float l;
    private float m;
    private float n;
    private ColorStateList o;
    private boolean p = true;
    private boolean q = true;
    private boolean r = false;

    interface RoundRectHelper {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        if (colorStateList2 == null) {
            this.e = ColorStateList.valueOf(resources.getColor(R.color.cardview_shadow_start_color));
        } else {
            this.e = colorStateList2;
        }
        if (colorStateList3 == null) {
            this.f = ColorStateList.valueOf(resources.getColor(R.color.cardview_shadow_end_color));
        } else {
            this.f = colorStateList3;
        }
        this.c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.g = new Paint(5);
        b(colorStateList);
        this.h = new Paint(5);
        this.h.setStyle(Style.FILL);
        this.j = (float) ((int) (f2 + 0.5f));
        this.d = new RectF();
        this.i = new Paint(this.h);
        this.i.setAntiAlias(false);
        a(f3, f4);
    }

    static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - b) * ((double) f3))) : f2 * 1.5f;
    }

    static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - b) * ((double) f3))) : f2;
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.o = colorStateList;
        this.g.setColor(this.o.getColorForState(getState(), this.o.getDefaultColor()));
    }

    private int d(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        this.g.setAlpha(i2);
        this.h.setAlpha(i2);
        this.i.setAlpha(i2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.p = true;
    }

    private void a(float f2, float f3) {
        if (f2 < 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid shadow size ");
            sb.append(f2);
            sb.append(". Must be >= 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (f3 < 0.0f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid max shadow size ");
            sb2.append(f3);
            sb2.append(". Must be >= 0");
            throw new IllegalArgumentException(sb2.toString());
        } else {
            float d2 = (float) d(f2);
            float d3 = (float) d(f3);
            if (d2 > d3) {
                if (!this.r) {
                    this.r = true;
                }
                d2 = d3;
            }
            if (this.n != d2 || this.l != d3) {
                this.n = d2;
                this.l = d3;
                this.m = (float) ((int) ((d2 * 1.5f) + ((float) this.c) + 0.5f));
                this.p = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.l, this.j, this.q));
        int ceil2 = (int) Math.ceil((double) b(this.l, this.j, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.o.getColorForState(iArr, this.o.getDefaultColor());
        if (this.g.getColor() == colorForState) {
            return false;
        }
        this.g.setColor(colorForState);
        this.p = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.o != null && this.o.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.p) {
            b(getBounds());
            this.p = false;
        }
        canvas.translate(0.0f, this.n / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.n) / 2.0f);
        a.a(canvas, this.d, this.j, this.g);
    }

    private void a(Canvas canvas) {
        float f2 = (-this.j) - this.m;
        float f3 = this.j + ((float) this.c) + (this.n / 2.0f);
        float f4 = 2.0f * f3;
        boolean z = this.d.width() - f4 > 0.0f;
        boolean z2 = this.d.height() - f4 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.d.left + f3, this.d.top + f3);
        canvas.drawPath(this.k, this.h);
        if (z) {
            canvas.drawRect(0.0f, f2, this.d.width() - f4, -this.j, this.i);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.d.right - f3, this.d.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.k, this.h);
        if (z) {
            canvas.drawRect(0.0f, f2, this.d.width() - f4, (-this.j) + this.m, this.i);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.d.left + f3, this.d.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.k, this.h);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.d.height() - f4, -this.j, this.i);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.d.right - f3, this.d.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.k, this.h);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.d.height() - f4, -this.j, this.i);
        }
        canvas.restoreToCount(save4);
    }

    private void g() {
        RectF rectF = new RectF(-this.j, -this.j, this.j, this.j);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.m, -this.m);
        if (this.k == null) {
            this.k = new Path();
        } else {
            this.k.reset();
        }
        this.k.setFillType(FillType.EVEN_ODD);
        this.k.moveTo(-this.j, 0.0f);
        this.k.rLineTo(-this.m, 0.0f);
        this.k.arcTo(rectF2, 180.0f, 90.0f, false);
        this.k.arcTo(rectF, 270.0f, -90.0f, false);
        this.k.close();
        float f2 = this.j / (this.j + this.m);
        int colorForState = this.e.getColorForState(getState(), this.e.getDefaultColor());
        int colorForState2 = this.f.getColorForState(getState(), this.f.getDefaultColor());
        Paint paint = this.h;
        RadialGradient radialGradient = new RadialGradient(0.0f, 0.0f, this.m + this.j, new int[]{colorForState, colorForState, colorForState2}, new float[]{0.0f, f2, 1.0f}, TileMode.CLAMP);
        paint.setShader(radialGradient);
        Paint paint2 = this.i;
        int[] iArr = {colorForState, colorForState, colorForState2};
        LinearGradient linearGradient = new LinearGradient(0.0f, (-this.j) + this.m, 0.0f, (-this.j) - this.m, iArr, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.i.setAntiAlias(false);
    }

    private void b(Rect rect) {
        float f2 = this.l * 1.5f;
        this.d.set(((float) rect.left) + this.l, ((float) rect.top) + f2, ((float) rect.right) - this.l, ((float) rect.bottom) - f2);
        g();
    }

    /* access modifiers changed from: 0000 */
    public float a() {
        return this.j;
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        if (f2 < 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid radius ");
            sb.append(f2);
            sb.append(". Must be >= 0");
            throw new IllegalArgumentException(sb.toString());
        }
        float f3 = (float) ((int) (f2 + 0.5f));
        if (this.j != f3) {
            this.j = f3;
            this.p = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    public float b() {
        return this.n;
    }

    /* access modifiers changed from: 0000 */
    public void b(float f2) {
        a(f2, this.l);
    }

    /* access modifiers changed from: 0000 */
    public float c() {
        return this.l;
    }

    /* access modifiers changed from: 0000 */
    public void c(float f2) {
        a(this.n, f2);
    }

    /* access modifiers changed from: 0000 */
    public float d() {
        return (Math.max(this.l, this.j + ((float) this.c) + (this.l / 2.0f)) * 2.0f) + ((this.l + ((float) this.c)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    public float e() {
        return (Math.max(this.l, this.j + ((float) this.c) + ((this.l * 1.5f) / 2.0f)) * 2.0f) + (((this.l * 1.5f) + ((float) this.c)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList f() {
        return this.o;
    }

    /* access modifiers changed from: 0000 */
    public void a(@Nullable ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }
}
