package com.google.gooddoctor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

import com.google.gooddoctor.util.DisplayUtil;

public class RecyclerViewDivider extends ItemDecoration {
    private static final int[] e = {16843284};
    private Paint a;
    private Drawable b;
    private int c = 2;
    private int d;

    public RecyclerViewDivider(Context context, int i) {
        if (i == 1 || i == 0) {
            this.d = i;
            this.c = DisplayUtil.a(context, 12.0f);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e);
            this.b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.d == 1) {
            b(canvas, recyclerView);
        } else {
            a(canvas, recyclerView);
        }
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.c + bottom;
            if (this.b != null) {
                this.b.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.b.draw(canvas);
            }
            if (this.a != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, this.a);
            }
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.c + right;
            if (this.b != null) {
                this.b.setBounds(right, paddingTop, i2, measuredHeight);
                this.b.draw(canvas);
            }
            if (this.a != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, this.a);
            }
        }
    }
}
