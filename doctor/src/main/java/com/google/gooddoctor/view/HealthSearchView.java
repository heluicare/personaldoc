package com.google.gooddoctor.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.util.DisplayUtil;

public class HealthSearchView extends LinearLayout  {
	private static final int[] c = {R.id.first_title, R.id.second_title, R.id.third_title, R.id.forth_title};
	private LinearLayout a;
    private TextView b;

	public HealthSearchView(Context context) {
        super(context);
        a();
    }

    public HealthSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HealthSearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
	
	private void a() {
        try {
            LayoutParams layoutParams = new LayoutParams(-1, (int) (((float) DisplayUtil.b(getContext())) * 0.08f));
            setLayoutParams(layoutParams);
            LayoutInflater.from(getContext()).inflate(R.layout.health_search_layout, this, true);
            this.a = (LinearLayout) findViewById(R.id.layout);
            this.a.setLayoutParams(layoutParams);
            this.b = (TextView) findViewById(R.id.title);
            for (int findViewById : c) {
                TextView textView = (TextView) findViewById(findViewById);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.TRANSPARENT);
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                gradientDrawable.setStroke(DisplayUtil.a(getContext(), 0.5f), -419430401);
                gradientDrawable.setCornerRadius((float) DisplayUtil.a(getContext(), 10.0f));
                textView.setBackground(gradientDrawable);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


	
	
}