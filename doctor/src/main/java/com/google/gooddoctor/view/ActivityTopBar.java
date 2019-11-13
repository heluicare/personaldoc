package com.google.gooddoctor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gooddoctor.R;
import com.google.gooddoctor.util.DisplayUtil;

public class ActivityTopBar extends LinearLayout implements View.OnClickListener {
	
	public Context b;
    private LinearLayout c;
    private ImageView d;
    private TextView e;
    private RelativeLayout f;
    private ImageView g;
    private TextView h;
    private Button i;
    private View j;
    private RelativeLayout k;
    public RotateYLayout l;
    public RotateImageView m;
    private ImageView n;
    public TextView o;
    public String q;
    private String r;
    public String s;
    public boolean t = false;
    public String u;
    public int v = 0;


	public ActivityTopBar(Context context) {
        super(context);
        a(context);
    }

    public ActivityTopBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActivityTopBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

	private void a(Context context) {
        this.b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_top_bar, null);
        this.c = (LinearLayout) inflate.findViewById(R.id.topbar_scan);
        this.d = (ImageView) inflate.findViewById(R.id.imageScan);
        this.e = (TextView) inflate.findViewById(R.id.textScan);
        this.f = (RelativeLayout) inflate.findViewById(R.id.topbar_msg);
        this.g = (ImageView) inflate.findViewById(R.id.imageMsg);
        this.h = (TextView) inflate.findViewById(R.id.txtMsg);
        this.i = (Button) inflate.findViewById(R.id.topbar_msg_count);
        this.k = (RelativeLayout) inflate.findViewById(R.id.topbar_search);
        this.l = (RotateYLayout) inflate.findViewById(R.id.search_voiceview_icon);
        this.m = (RotateImageView) inflate.findViewById(R.id.search_voice_rotate_icon);
        this.n = (ImageView) inflate.findViewById(R.id.search_icon);
        this.o = (TextView) inflate.findViewById(R.id.search_tip);
        this.j = inflate.findViewById(R.id.topbar_msg_tips);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        addView(inflate);
        a();
    }
	
	public void a() {
        a(R.drawable.topbar_msg, R.drawable.topbar_scan, R.color.topbar_icon_text, R.drawable.sy_bg_search_nav_view_radius_white);
        a(7, 12, 10);
    }
	
	private void a(int i2, int i3, int i4, int i5) {
        setScanIcon(i3);
        setMessageIcon(i2);
        setScanTextColor(i4);
        setMsgTextColor(i4);
        setSearchBackgroundResource(i5);
    }
	
	public void setScanIcon(int i2) {
        this.d.setImageResource(i2);
    }

	public void setMessageIcon(int i2) {
        this.g.setImageResource(i2);
    }
	
	public void setScanTextColor(int i2) {
        this.e.setTextColor(getResources().getColor(i2));
    }

    public void setMsgTextColor(int i2) {
        this.h.setTextColor(getResources().getColor(i2));
    }
	
	public void setSearchBackgroundResource(int i2) {
        this.k.setBackgroundResource(i2);
    }
	
	private void a(int i2, int i3, int i4) {
        int a2 = DisplayUtil.a(this.b, (float) i2);
        int a3 = DisplayUtil.a(this.b, (float) i3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.setMargins(a3, a2, a3, a2);
        this.k.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams2.setMargins(DisplayUtil.a(this.b, (float) i4), DisplayUtil.a(this.b, 1.0f), 0, 0);
        this.n.setLayoutParams(layoutParams2);
    }
	
	public void setTopbarSearchTipsColor(int i2) {
        this.v = i2;
        if (this.t) {
            this.o.setTextColor(this.v);
        }
    }

    @Override
    public void onClick(View v) {

    }

}