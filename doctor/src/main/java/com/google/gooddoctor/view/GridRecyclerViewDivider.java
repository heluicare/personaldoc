package com.google.gooddoctor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.google.gooddoctor.util.DisplayUtil;

public class GridRecyclerViewDivider extends ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private final int DIVIDER_DEFAULT = -1;
    private Context context;
    private boolean hasDividerLine = false;
    private int horizontalDividerHeight;
    private Drawable mDivider;
    private int mDividerColor = -1;
    private int verticalDividerHeight = 0;

    public GridRecyclerViewDivider(Context context2, boolean z) {
        this.context = context2;
        this.hasDividerLine = z;
        if (z) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(ATTRS);
            this.mDivider = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }
    }

    public void setDividerColor(int i) {
        this.mDividerColor = i;
    }

    public void setDividerHeight(int i, int i2) {
        this.horizontalDividerHeight = DisplayUtil.a(this.context, (float) i);
        this.verticalDividerHeight = DisplayUtil.a(this.context, (float) i2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        drawVertical(canvas, recyclerView);
        drawHorizontal(canvas, recyclerView);
    }

    private int getDividerLineWidth() {
        if (this.hasDividerLine) {
            return this.mDivider.getIntrinsicWidth();
        }
        return 0;
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        Paint paint = new Paint();
        paint.setColor(this.mDividerColor);
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int top2 = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int right = childAt.getRight() + layoutParams.rightMargin;
            int dividerLineWidth = getDividerLineWidth() + right + this.verticalDividerHeight;
            if (this.hasDividerLine) {
                this.mDivider.setBounds(right, top2, dividerLineWidth, bottom);
                this.mDivider.draw(canvas);
            } else {
                canvas.drawRect(new RectF((float) right, (float) top2, (float) dividerLineWidth, (float) bottom), paint);
            }
        }
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        Paint paint = new Paint();
        paint.setColor(this.mDividerColor);
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft() - layoutParams.leftMargin;
            int right = childAt.getRight() + layoutParams.rightMargin + getDividerLineWidth() + this.horizontalDividerHeight;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int dividerLineWidth = getDividerLineWidth() + bottom;
            if (this.hasDividerLine) {
                this.mDivider.setBounds(left, bottom, right, dividerLineWidth);
                this.mDivider.draw(canvas);
            } else {
                canvas.drawRect(new RectF((float) left, (float) bottom, (float) right, (float) dividerLineWidth), paint);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int spanCount = getSpanCount(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (isLastColum(recyclerView, childAdapterPosition, spanCount, itemCount)) {
            rect.set(0, 0, 0, getDividerLineWidth() + this.verticalDividerHeight);
        } else if (isLastRaw(recyclerView, childAdapterPosition, spanCount, itemCount)) {
            rect.set(0, 0, getDividerLineWidth() + this.horizontalDividerHeight, 0);
        } else {
            rect.set(0, 0, getDividerLineWidth() + this.horizontalDividerHeight, getDividerLineWidth() + this.verticalDividerHeight);
        }
    }

    private int getSpanCount(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private boolean isLastColum(RecyclerView recyclerView, int i, int i2, int i3) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((i + 1) % i2 == 0) {
                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if ((i + 1) % i2 == 0) {
                    return true;
                }
            } else if (i >= i3 - (i3 % i2)) {
                return true;
            }
        } else if ((layoutManager instanceof LinearLayoutManager) && i >= i3 - 1) {
            return true;
        }
        return false;
    }

    private boolean isLastRaw(RecyclerView recyclerView, int i, int i2, int i3) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (i >= i3 - (i3 % i2)) {
                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if (i >= i3 - (i3 % i2)) {
                    return true;
                }
            } else if ((i + 1) % i2 == 0) {
                return true;
            }
        } else if ((layoutManager instanceof LinearLayoutManager) && i >= i3 - 1) {
            return true;
        }
        return false;
    }
}
