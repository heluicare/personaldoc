package com.google.gooddoctor.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.util.DisplayUtil;
import com.google.gooddoctor.util.PtrCLog;

public class MineOrderView extends LinearLayout implements View.OnClickListener {

    private Context a;
    private View b;
    public OnItemClickListener c;

    public interface OnItemClickListener {
        void a(String tag);
    }

    private static class ViewHolder {
        LinearLayout a;
        LinearLayout b;
        LinearLayout c;
        LinearLayout d;
        LinearLayout e;
        LinearLayout f;
        TextView g;
        TextView h;
        TextView i;
        TextView j;
        TextView k;

        private ViewHolder() {
        }
    }

    public MineOrderView(Context context) {
        super(context);
        a();
    }

    public MineOrderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MineOrderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = LayoutInflater.from(getContext()).inflate(R.layout.layout_mine_order_view, this, true);
        this.a = getContext();
        setViewClick(this.b);
    }

    public void a(int i, int i2, int i3, int i4) {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.b != null) {
            if (i > 0) {
                ViewHolder a2 = a(this.b);
                a2.h.setVisibility(View.VISIBLE);
                a(a2.h, i);
                TextView textView = a2.h;
                if (i > 99) {
                    str4 = this.a.getString(R.string.counts_maxvalue_99);
                } else {
                    str4 = String.format("%d", new Object[]{Integer.valueOf(i)});
                }
                textView.setText(str4);
            } else {
                a(this.b).h.setVisibility(View.GONE);
            }
            if (i2 > 0) {
                ViewHolder a3 = a(this.b);
                a3.i.setVisibility(View.VISIBLE);
                a(a3.i, i2);
                TextView textView2 = a3.i;
                if (i2 > 99) {
                    str3 = this.a.getString(R.string.counts_maxvalue_99);
                } else {
                    str3 = String.format("%d", new Object[]{Integer.valueOf(i2)});
                }
                textView2.setText(str3);
            } else {
                a(this.b).i.setVisibility(View.GONE);
            }
            if (i3 > 0) {
                ViewHolder a4 = a(this.b);
                a4.j.setVisibility(View.VISIBLE);
                a(a4.j, i3);
                TextView textView3 = a4.j;
                if (i3 > 99) {
                    str2 = this.a.getString(R.string.counts_maxvalue_99);
                } else {
                    str2 = String.format("%d", new Object[]{Integer.valueOf(i3)});
                }
                textView3.setText(str2);
            } else {
                a(this.b).j.setVisibility(View.GONE);
            }
            if (i4 > 0) {
                ViewHolder a5 = a(this.b);
                a5.k.setVisibility(View.VISIBLE);
                a(a5.k, i4);
                TextView textView4 = a5.k;
                if (i4 > 99) {
                    str = this.a.getString(R.string.counts_maxvalue_99);
                } else {
                    str = String.format("%d", new Object[]{Integer.valueOf(i4)});
                }
                textView4.setText(str);
            } else {
                a(this.b).k.setVisibility(View.GONE);
            }
        }
    }

    public void a(int i) {
        String str;
        if (this.b != null) {
            if (i > 0) {
                ViewHolder a2 = a(this.b);
                a2.g.setVisibility(View.VISIBLE);
                a(a2.g, i);
                TextView textView = a2.g;
                if (i > 99) {
                    str = this.a.getString(R.string.counts_maxvalue_99);
                } else {
                    str = String.format("%d", new Object[]{Integer.valueOf(i)});
                }
                textView.setText(str);
            } else {
                a(this.b).g.setVisibility(View.GONE);
            }
        }
    }

    private void a(View view, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FF4321"));
        if (i <= 99) {
            gradientDrawable.setShape(GradientDrawable.OVAL);
            gradientDrawable.setStroke(2, -1);
            gradientDrawable.setCornerRadius((float) DisplayUtil.a(getContext(), 50.0f));
            int a2 = DisplayUtil.a(getContext(), 18.0f);
            gradientDrawable.setSize(a2, a2);
            view.setMinimumWidth(a2);
            view.setMinimumHeight(a2);
        } else if (i > 99) {
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable.setStroke(2, -1);
            gradientDrawable.setCornerRadius((float) DisplayUtil.a(getContext(), 15.0f));
            gradientDrawable.setSize(DisplayUtil.a(getContext(), 25.0f), DisplayUtil.a(getContext(), 10.0f));
        }
        view.setBackground(gradientDrawable);
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }

    private ViewHolder a(View view) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.a = (LinearLayout) view.findViewById(R.id.ll_order_list);
        viewHolder.b = (LinearLayout) view.findViewById(R.id.ll_shop_cart);
        viewHolder.c = (LinearLayout) view.findViewById(R.id.rl_order_need_pay);
        viewHolder.d = (LinearLayout) view.findViewById(R.id.rl_order_ongoing);
        viewHolder.e = (LinearLayout) view.findViewById(R.id.rl_order_finish);
        viewHolder.f = (LinearLayout) view.findViewById(R.id.rl_complain);
        viewHolder.g = (TextView) view.findViewById(R.id.tv_shop_cart_num);
        viewHolder.h = (TextView) view.findViewById(R.id.tv_need_pay_num);
        viewHolder.i = (TextView) view.findViewById(R.id.tv_ongoing_num);
        viewHolder.j = (TextView) view.findViewById(R.id.tv_review_num);
        viewHolder.k = (TextView) view.findViewById(R.id.tv_complain_num);
        //我的订单
        viewHolder.b.setOnClickListener(this);
        viewHolder.a.setOnClickListener(this);
        viewHolder.c.setOnClickListener(this);
        viewHolder.d.setOnClickListener(this);
        viewHolder.e.setOnClickListener(this);
        viewHolder.f.setOnClickListener(this);
        //医疗服务
        findViewById(R.id.ll_wdwz).setOnClickListener(this);
        findViewById(R.id.ll_wdys).setOnClickListener(this);
        findViewById(R.id.ll_wdyy).setOnClickListener(this);
        findViewById(R.id.ll_wdtj).setOnClickListener(this);
        findViewById(R.id.ll_wdgh).setOnClickListener(this);
        //
        findViewById(R.id.ll_zj100).setOnClickListener(this);
        findViewById(R.id.ll_hongbao).setOnClickListener(this);
        findViewById(R.id.ll_jkjd).setOnClickListener(this);
        findViewById(R.id.ll_888hongbao).setOnClickListener(this);
        //健康服务
        findViewById(R.id.ll_sjys).setOnClickListener(this);
        findViewById(R.id.ll_yxl).setOnClickListener(this);
        findViewById(R.id.ll_myzx).setOnClickListener(this);
        findViewById(R.id.ll_bbdj).setOnClickListener(this);
        findViewById(R.id.ll_jksj).setOnClickListener(this);
        //常用工具
        findViewById(R.id.ll_xxjl).setOnClickListener(this);
        findViewById(R.id.ll_yqyj).setOnClickListener(this);
        findViewById(R.id.ll_wdsc).setOnClickListener(this);
        findViewById(R.id.ll_wdzb).setOnClickListener(this);
        findViewById(R.id.ll_fkzx).setOnClickListener(this);
        //金融服务
        findViewById(R.id.ll_yaoqh).setOnClickListener(this);
        findViewById(R.id.ll_bby).setOnClickListener(this);
        findViewById(R.id.ll_jfjd).setOnClickListener(this);
        findViewById(R.id.ll_360jd).setOnClickListener(this);
        findViewById(R.id.ll_yqh).setOnClickListener(this);
        return viewHolder;
    }

    private void setViewClick(View view) {
       a(view);
    }

    @Override
    public void onClick(View v) {
        String tag = "";
        switch (v.getId())
        {
            case R.id.ll_shop_cart:
                tag = "gouwuche";
                break;
            case R.id.rl_order_need_pay:
                tag = "daifukuan";
                break;
            case R.id.rl_order_ongoing:
                tag = "daishouhuo";
                break;
            case R.id.rl_complain:
                tag = "daipingjia";
                break;
            case R.id.rl_order_finish:
                tag = "tuikuanshouhou";
                break;
            case R.id.ll_order_list:
                tag = "gengduodingdan";
                break;
            case R.id.ll_wdwz:
                tag = "wdwenzhen";
                break;
            case R.id.ll_wdys:
                tag = "wdyisheng";
                break;
            case R.id.ll_wdyy:
                tag = "wdyongyao";
                break;
            case R.id.ll_wdtj:
                tag = "wdtijian";
                break;
            case R.id.ll_wdgh:
                tag = "wdguahao";
                break;
            case R.id.ll_zj100:
                tag = "zhijiang1000";
                break;
            case R.id. ll_hongbao:
                tag = "100wanghongbao";
                break;
            case R.id.ll_jkjd:
                tag = "jiankangjindui";
                break;
            case R.id.ll_888hongbao:
                tag = "888hongbao";
                break;
            case R.id.ll_sjys:
                tag = "sijiayisheng";
                break;
            case R.id.ll_yxl:
                tag = "aixinli";
                break;
            case R.id.ll_myzx:
                tag = "muyingzhongxin";
                break;
            case R.id.ll_bbdj:
                tag = "bubuduojin";
                break;
            case R.id.ll_jksj:
                tag = "jiankangshuju";
                break;
            case R.id.ll_xxjl:
                tag = "xianjinjiangli";
                break;
            case R.id.ll_yqyj:
                tag = "yaoqingyoujiang";
                break;
            case R.id.ll_wdsc:
                tag = "wdshoucang";
                break;
            case R.id.ll_wdzb:
                tag = "wqzhibo";
                break;
            case R.id.ll_fkzx:
                tag = "fankuishuju";
                break;
            case R.id.ll_yaoqh:
                tag = "yaoqianhua";
                break;
            case R.id.ll_bby:
                tag = "bubuying";
                break;
            case R.id.ll_jfjd:
                tag = "jiufujiedai";
                break;
            case R.id.ll_360jd:
                tag = "360jiadai";
                break;
            case R.id.ll_yqh:
                tag = "youqianhua";
                break;
            default:
                break;
        }
        if (!TextUtils.isEmpty(tag) && MineOrderView.this.c != null) {
            MineOrderView.this.c.a(tag);
        }
    }

}