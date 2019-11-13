package com.google.gooddoctor.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(21)
class CardViewApi21Impl extends CardViewApi17Impl {

    private boolean a = false;

    CardViewApi21Impl() {
    }

    public void a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        if (colorStateList2 == null && colorStateList3 == null) {
            this.a = false;
            cardViewDelegate.a(new RoundRectDrawable(colorStateList, f));
            View d = cardViewDelegate.d();
            d.setClipToOutline(true);
            d.setElevation(f2);
            b(cardViewDelegate, f3);
            return;
        }
        this.a = true;
        super.a(cardViewDelegate, context, colorStateList, f, f2, f3, colorStateList2, colorStateList3);
    }

    public void a(CardViewDelegate cardViewDelegate, float f) {
        if (this.a) {
            super.a(cardViewDelegate, f);
        } else {
            j(cardViewDelegate).a(f);
        }
    }

    public void b(CardViewDelegate cardViewDelegate, float f) {
        if (this.a) {
            super.b(cardViewDelegate, f);
            return;
        }
        j(cardViewDelegate).a(f, cardViewDelegate.a(), cardViewDelegate.b());
        f(cardViewDelegate);
    }

    public float a(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.a(cardViewDelegate);
        }
        return j(cardViewDelegate).a();
    }

    public float b(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.b(cardViewDelegate);
        }
        return d(cardViewDelegate) * 2.0f;
    }

    public float c(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.c(cardViewDelegate);
        }
        return d(cardViewDelegate) * 2.0f;
    }

    public float d(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.d(cardViewDelegate);
        }
        return j(cardViewDelegate).b();
    }

    public void c(CardViewDelegate cardViewDelegate, float f) {
        if (this.a) {
            super.c(cardViewDelegate, f);
        } else {
            cardViewDelegate.d().setElevation(f);
        }
    }

    public float e(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.e(cardViewDelegate);
        }
        return cardViewDelegate.d().getElevation();
    }

    public void f(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            super.f(cardViewDelegate);
        } else if (!cardViewDelegate.a()) {
            cardViewDelegate.a(0, 0, 0, 0);
        } else {
            float a2 = a(cardViewDelegate);
            float d = d(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.b(a2, d, cardViewDelegate.b()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.a(a2, d, cardViewDelegate.b()));
            cardViewDelegate.a(ceil, ceil2, ceil, ceil2);
        }
    }

    public void g(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            super.g(cardViewDelegate);
        } else {
            b(cardViewDelegate, a(cardViewDelegate));
        }
    }

    public void h(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            super.h(cardViewDelegate);
        } else {
            b(cardViewDelegate, a(cardViewDelegate));
        }
    }

    public void a(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        if (this.a) {
            super.a(cardViewDelegate, colorStateList);
        } else {
            j(cardViewDelegate).a(colorStateList);
        }
    }

    public ColorStateList i(CardViewDelegate cardViewDelegate) {
        if (this.a) {
            return super.i(cardViewDelegate);
        }
        return j(cardViewDelegate).c();
    }

    private RoundRectDrawable j(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.c();
    }
}
