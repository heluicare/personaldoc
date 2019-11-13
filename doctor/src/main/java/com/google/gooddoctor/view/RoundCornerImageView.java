package com.google.gooddoctor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


public class RoundCornerImageView extends AppCompatImageView {

    private Context a;
    private float[] b = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public RoundCornerImageView(Context context) {
        super(context);
        this.a = context;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.b = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public void setTopLeftRadius(float f) {
        a(f, 0.0f, 0.0f, 0.0f);
    }

    public void setTopRightRadius(float f) {
        a(0.0f, f, 0.0f, 0.0f);
    }

    public void setBottomLeftRadius(float f) {
        a(0.0f, 0.0f, f, 0.0f);
    }

    public void setBottomRightRadius(float f) {
        a(0.0f, 0.0f, f, 0.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.b, Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

}
