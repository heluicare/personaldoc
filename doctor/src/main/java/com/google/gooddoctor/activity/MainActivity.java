package com.google.gooddoctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.adapter.MainFragmentPagerAdapter;
import com.google.gooddoctor.fragment.MainPageFragment;
import com.google.gooddoctor.fragment.NewMineTabFragment;
import com.google.gooddoctor.fragment.WebViewTabFragment;
import com.google.gooddoctor.util.BitmapFactoryInstrumentation;
import com.google.gooddoctor.util.StatusBarUtils;
import com.google.gooddoctor.view.ActivityTopBar;
import com.google.gooddoctor.view.HealthSearchView;
import com.google.gooddoctor.view.NoSwipeViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
	
    public NoSwipeViewPager c;
    private HealthSearchView v;
    public ActivityTopBar q;
	public View[] r = new View[3];
    private TextView[] s = new TextView[3];
    private ImageView[] t = new ImageView[3];
    public View u;
    private MainFragmentPagerAdapter fragmentPagerAdapter;
	
	class IconBitmaps {
        Bitmap a;
        Bitmap b;

        public IconBitmaps() {
            a();
        }

        public void a() {
            this.a = null;
            this.b = null;
        }

        public void b() {
            if (this.a != null && !this.a.isRecycled()) {
                this.a.recycle();
                this.a = null;
            }
            if (this.b != null && !this.b.isRecycled()) {
                this.b.recycle();
                this.b = null;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setTransparentStatusBar(this, false);
        setContentView(R.layout.activity_main);
		this.u = findViewById(R.id.main_layout);

		//当设置了沉浸式时，预留标题栏高度的空间
        if (!(this instanceof MainActivity)) {
            this.u.setFitsSystemWindows(true);
        }else if (Build.VERSION.SDK_INT >= 21) {
            this.u.setFitsSystemWindows(false);
            View findViewById = this.u.findViewById(R.id.v_status_placeholder);
            findViewById.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
            findViewById.setLayoutParams(layoutParams);
        } else {
            this.u.setFitsSystemWindows(true);
        }

		b();
		o();
        p();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AdDialog(MainActivity.this, R.style.MyDialog).show();
            }
        }, 800);
    }
	
	public void b() {
        this.v = (HealthSearchView) findViewById(R.id.hsv);
        this.v.setBackgroundResource(R.drawable.main_medical_bg);
        this.q = (ActivityTopBar) findViewById(R.id.layoutTopBar);
        a(1.0f);
	}

	public final void a(float f2) {
        int i2 = getResources().getColor(R.color.medical_home_top_bar_default_endcolor);
        int i3 = R.drawable.main_medical_bg;
        this.q.setBackgroundResource(i3);
        this.q.setTopbarSearchTipsColor(i2);
        this.q.setAlpha(f2);
        a(-1, i3, f2);
    }
	
	public final void a(int i2, int i3, float f2) {
        if (i2 != -1) {
            this.v.setBackgroundColor(i2);
        } else if (i3 != -1) {
            this.v.setBackgroundResource(i3);
        }
        this.v.setAlpha(f2);
    }

	private void o() {
        this.c = (NoSwipeViewPager) findViewById(R.id.vp_home);
        this.c.setAdapter(g());
    }

	public MainFragmentPagerAdapter g() {
		this.fragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), a());
        return this.fragmentPagerAdapter;
    }
	
	public List<Fragment> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c());
        arrayList.add(WebViewTabFragment.a("https://www.jk.cn/mauritius/social-tab.html?page_source=zyspd", getString(R.string.main_medical_hospital), 0, true, null, "finddoctor_tab", false));
        NewMineTabFragment newMineTabFragment = new NewMineTabFragment();
        newMineTabFragment.a(false, "medmine");
        arrayList.add(newMineTabFragment);
        return arrayList;
    }

	
	private Fragment c() {
		return MainPageFragment.a("mainpagefragment", -1);
	}

	private void p() {
        this.r[0] = findViewById(R.id.layoutTab1);
		this.r[1] = findViewById(R.id.layoutTab2);
		this.r[2] = findViewById(R.id.layoutTab4);
		this.s[0] = (TextView) findViewById(R.id.textTab1);
		this.s[1] = (TextView) findViewById(R.id.textTab2);
		this.s[2] = (TextView) findViewById(R.id.textTab4);
		this.t[0] = (ImageView) findViewById(R.id.footTips1);
		this.t[1] = (ImageView) findViewById(R.id.footTips2);
		this.t[2] = (ImageView) findViewById(R.id.footTips4);
        for (int i = 0; i < 3; i++) {
            final int i2 = i;
            this.r[i2].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MainActivity.this.a(i2);
                }
            });
        }
//        a(this, findViewById(R.id.layoutFootBar), this.s, this.r[2]);
        int r2 = 0;
        this.r[r2].setSelected(true);
        this.c.setCurrentItem(r2, false);
        c(r2);
    }
	
	public void a(int i2) {
        if (i2 != this.c.getCurrentItem() && i2 < 4) {
            this.c.setOffscreenPageLimit(1);
            c(i2);
            this.c.setCurrentItem(i2, false);
            for (int i3 = 0; i3 < 3; i3++) {
                if (i3 == i2) {
                    this.r[i3].setSelected(true);
                    this.s[i3].setTypeface(null, Typeface.BOLD);
                } else {
                    this.r[i3].setSelected(false);
                    this.s[i3].setTypeface(null, Typeface.NORMAL);
                }
            }
        }
    }

	
	public void c(int r7) {
        a(this, this.s, r7);
	    switch (r7){
            case 0:
            case 1:
                this.q.setVisibility(View.VISIBLE);
                break;
            case 2:
                this.q.setVisibility(View.GONE);
                break;
            default:
                break;
        }
	}

	private void a(Activity activity, TextView[] textViewArr, int selectedIndex) {
        ColorStateList colorStateList;
        if (textViewArr != null && textViewArr.length == 3) {
			colorStateList = activity.getResources().getColorStateList(R.color.main_tab_text_press_medical);
            a(activity);
            for (int i = 0; i < 3; i++) {
                if (i != selectedIndex) {
                    a(activity, textViewArr[i]);
                    textViewArr[i].setTextColor(activity.getResources().getColorStateList(R.color.main_tab_text_normal));
                } else {
                    a(activity, i, textViewArr[i]);
                    textViewArr[i].setTextColor(colorStateList);
                    textViewArr[i].setTypeface(null, Typeface.BOLD);
                }
            }
        }
    }
	
	private void a(Activity activity, TextView textView) {
//        a(activity, 3, textView);
    }

	private IconBitmaps[] a;
	private void a(Activity activity, int i, TextView textView) {
        StateListDrawable a2 = a((Drawable) new BitmapDrawable(activity.getResources(), a[i].b), (Drawable) new BitmapDrawable(activity.getResources(), a[i].a));
        if (a2 != null) {
            int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.jigsaw_tab_bar_icon);
            a2.setBounds(0, 0, (a2.getIntrinsicWidth() * dimensionPixelOffset) / a2.getIntrinsicHeight(), dimensionPixelOffset);
            if (textView != null) {
                textView.setCompoundDrawables(null, a2, null, null);
            }
        }
    }
	
	private static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[]{16842908}, drawable);
        stateListDrawable.addState(new int[]{16842913}, drawable);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

	
	private void a(Activity activity) {
		a = new IconBitmaps[]{new IconBitmaps(), new IconBitmaps(), new IconBitmaps(), new IconBitmaps(), new IconBitmaps(), new IconBitmaps()};
		if (a[0].a == null) {
			a[0].a = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_zxkb_normal);
		}
		if (a[0].b == null) {
            a[0].b = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_zxkb_press);
		}
		if (a[1].a == null) {
			a[1].a = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_quyiyuan_normal);
		}
		if (a[1].b == null) {
			a[1].b = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_quyiyuan_press);
		}
		if (a[2].a == null) {
			a[2].a = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_mine_normal);
		}
		if (a[2].b == null) {
			a[2].b = BitmapFactoryInstrumentation.decodeResource(activity.getResources(), R.drawable.main_mine_meical);
		}
    }



}
