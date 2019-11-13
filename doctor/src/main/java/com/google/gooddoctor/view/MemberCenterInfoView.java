package com.google.gooddoctor.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.util.DisplayUtil;
import com.google.gooddoctor.util.GlideUtil;
import com.google.gooddoctor.util.ImageUtils;
import com.google.gooddoctor.util.PtrCLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberCenterInfoView extends LinearLayout implements OnClickListener {

    String a;
    List<MemberData> b;
    private String c;
    private View d;
    private JKViewFlipper e;
    private TextView f;
    private int g;

    public static class MemberData {
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
    }

    public MemberCenterInfoView(Context context) {
        super(context);
        this.a = "MemberCenterInfoView";
        this.g = 8;
        a();
    }

    public MemberCenterInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MemberCenterInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "MemberCenterInfoView";
        this.g = 8;
        a();
    }

    private void a() {
        this.d = LayoutInflater.from(getContext()).inflate(R.layout.layout_mine_memberinfo_view, this, true);
        this.f = (TextView) this.d.findViewById(R.id.tv_memeberinfo_exp);
        this.e = (JKViewFlipper) this.d.findViewById(R.id.vf);
        this.e.setFlipInterval(5000);

        //--------------测试数据开始--------------
        List<MemberData> tmplist = new ArrayList<MemberData>();
        MemberData m1 = new MemberData();
        m1.a = "升级享好礼";
        m1.b = "精选好物 健康金必兑";
        m1.c = "img1";
        m1.e = R.drawable.mine_flipper_ad1;
        tmplist.add(m1);
        MemberData m2 = new MemberData();
        m2.a = "会员专属";
        m2.b = "升级会员 大礼送不停";
        m2.c = "img2";
        m2.e = R.drawable.mine_flipper_ad2;
        tmplist.add(m2);
        setData(tmplist);
        //--------------测试数据结束--------------

        setOnClickListener(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(this.a, "onAttachedToWindow");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(this.a, "onDetachedFromWindow");
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            Log.i(this.a, "onWindowVisibilityChanged - 前台");
        } else {
            Log.i(this.a, "onWindowVisibilityChanged - 后台");
        }
        this.g = i;
    }

    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            Log.i(this.a, "onVisibilityChanged - 前台");
        } else {
            Log.i(this.a, "onVisibilityChanged - 后台");
        }
        this.g = i;
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        if (i == 0) {
            Log.i(this.a, "onWindowSystemUiVisibilityChanged - 前台");
        } else {
            Log.i(this.a, "onWindowSystemUiVisibilityChanged - 后台");
        }
        this.g = i;
    }

    public void dispatchVisibilityChanged(View view, int i) {
        super.dispatchVisibilityChanged(view, i);
        if (i == 0) {
            Log.i(this.a, "dispatchVisibilityChanged - 前台");
        } else {
            Log.i(this.a, "dispatchVisibilityChanged - 后台");
        }
        this.g = i;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            Log.i(this.a, "setVisibility - 前台");
        } else {
            Log.i(this.a, "setVisibility - 后台");
        }
        this.g = i;
    }

    public void a(boolean z) {
        if (this.e != null) {
            if (z) {
                Log.i("JKViewFlipper", "onViewVisible -- 显示");
            } else {
                Log.i("JKViewFlipper", "onViewVisible -- 隐藏");
            }
            if (!z || this.e.c()) {
                if (!z && this.e.c()) {
                    this.e.b();
                } else if (!z) {
                    this.e.b();
                }
            } else if (this.b != null && this.b.size() > 1) {
                this.e.setAutoStart(true);
                this.e.a();
            }
            this.g = z ? 0 : 8;
        }
    }

    public void setOnClickListener(@Nullable OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setSourcePage(String str) {
        this.c = str;
    }

    public void setData(List<MemberData> list) {
        View view;
        if (list != null) {
            if (list == null || list.size() != 0) {
                Collections.shuffle(list);
                this.b = list;
                if (this.e != null) {
                    int childCount = this.e.getChildCount();
                    for (int i = 0; i < list.size(); i++) {
                        if (i < childCount) {
                            view = this.e.getChildAt(i);
                        } else {
                            view = View.inflate(getContext(), R.layout.layout_mine_memberinfo_details, null);
                            this.e.addView(view);
                        }
                        if (view != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_tips_title);
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_tips_subtitle);
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_tips_gift);
                            textView.setText(((MemberData) list.get(i)).a);
                            textView2.setText(((MemberData) list.get(i)).b);
                            if (!TextUtils.isEmpty(((MemberData) list.get(i)).c)) {
                                Context context = getContext();
                                String str = ((MemberData) list.get(i)).c;
                                StringBuilder sb = new StringBuilder();
                                sb.append(DisplayUtil.a(getContext(), 60.0f));
                                sb.append("x");
                                sb.append(DisplayUtil.a(getContext(), 34.0f));
                                GlideUtil.a(context, imageView, ImageUtils.getThumbnailFullPath(str, sb.toString()), list.get(i).e);
                            }
                        }
                    }
                    if (childCount > list.size() && this.e != null) {
                        int size = list.size();
                        while (size < childCount) {
                            if (this.e.getChildAt(size) != null) {
                                this.e.removeViewAt(size);
                            }
                        }
                    }
                    if (this.e != null && !this.e.c() && this.g == 0) {
                        this.e.setAutoStart(true);
                        this.e.a();
                    }
                }
            }
        }
    }

    public void setExp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f.setText(str);
        }
    }

    public void onClick(View view) {
        if (this.b != null && this.e != null) {
            int displayedChild = this.e.getDisplayedChild();
            if (displayedChild < this.b.size() && !TextUtils.isEmpty(((MemberData) this.b.get(displayedChild)).d)) {
            }
        }
    }
}