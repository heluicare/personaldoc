package com.google.gooddoctor.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class CardViewApi17Impl extends CardViewBaseImpl {
    CardViewApi17Impl() {
    }

    public void a() {
        RoundRectDrawableWithShadow.a = new CardViewApi17Impl$$Lambda$0();
    }

    class CardViewApi17Impl$$Lambda$0 implements RoundRectDrawableWithShadow.RoundRectHelper {

        private CardViewApi17Impl$$Lambda$0() {
        }

        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

}
