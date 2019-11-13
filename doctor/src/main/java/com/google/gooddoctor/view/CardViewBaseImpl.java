package com.google.gooddoctor.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;

public class CardViewBaseImpl implements CardViewImpl {

    class CardViewBaseImpl$$Lambda$0 implements RoundRectDrawableWithShadow.RoundRectHelper {
        private final CardViewBaseImpl a;

        CardViewBaseImpl$$Lambda$0(CardViewBaseImpl cardViewBaseImpl) {
            this.a = cardViewBaseImpl;
        }

        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            this.a.b(canvas, rectF, f, paint);
        }
    }

    private final RectF a = new RectF();

    public void g(CardViewDelegate cardViewDelegate) {
    }

    CardViewBaseImpl() {
    }

    public void a() {
        RoundRectDrawableWithShadow.a = new CardViewBaseImpl$$Lambda$0(this);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void b(Canvas canvas, RectF rectF, float f, Paint paint) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        float f2 = 2.0f * f;
        float width = (rectF.width() - f2) - 1.0f;
        float height = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.a.set(f4, f4, f3, f3);
            int save = canvas.save();
            canvas2.translate(rectF2.left + f3, rectF2.top + f3);
            Canvas canvas3 = canvas2;
            canvas3.drawArc(this.a, 180.0f, 90.0f, true, paint);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            Paint paint2 = paint;
            canvas3.drawArc(this.a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(height, 0.0f);
            canvas2.rotate(90.0f);
            canvas3.drawArc(this.a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas3.drawArc(this.a, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(save);
            canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint);
            canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint);
        }
        canvas2.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
    }

    public void a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        RoundRectDrawableWithShadow a2 = a(context, colorStateList, f, f2, f3, colorStateList2, colorStateList3);
        a2.a(cardViewDelegate.b());
        CardViewDelegate cardViewDelegate2 = cardViewDelegate;
        cardViewDelegate2.a(a2);
        f(cardViewDelegate2);
    }

    private RoundRectDrawableWithShadow a(Context context, ColorStateList colorStateList, float f, float f2, float f3, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        RoundRectDrawableWithShadow roundRectDrawableWithShadow = new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3, colorStateList2, colorStateList3);
        return roundRectDrawableWithShadow;
    }

    public void f(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        j(cardViewDelegate).a(rect);
        cardViewDelegate.a((int) Math.ceil((double) b(cardViewDelegate)), (int) Math.ceil((double) c(cardViewDelegate)));
        cardViewDelegate.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h(CardViewDelegate cardViewDelegate) {
        j(cardViewDelegate).a(cardViewDelegate.b());
        f(cardViewDelegate);
    }

    public void a(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        j(cardViewDelegate).a(colorStateList);
    }

    public ColorStateList i(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).f();
    }

    public void a(CardViewDelegate cardViewDelegate, float f) {
        j(cardViewDelegate).a(f);
        f(cardViewDelegate);
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).a();
    }

    public void c(CardViewDelegate cardViewDelegate, float f) {
        j(cardViewDelegate).b(f);
    }

    public float e(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).b();
    }

    public void b(CardViewDelegate cardViewDelegate, float f) {
        j(cardViewDelegate).c(f);
        f(cardViewDelegate);
    }

    public float a(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).c();
    }

    public float b(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).d();
    }

    public float c(CardViewDelegate cardViewDelegate) {
        return j(cardViewDelegate).e();
    }

    private RoundRectDrawableWithShadow j(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.c();
    }
}
