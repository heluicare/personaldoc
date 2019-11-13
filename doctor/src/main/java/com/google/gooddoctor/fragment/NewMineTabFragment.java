package com.google.gooddoctor.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.activity.WebActivity;
import com.google.gooddoctor.adapter.MineAdapterNew;
import com.google.gooddoctor.adapter.MineDaynicContent;
import com.google.gooddoctor.util.DisplayUtil;
import com.google.gooddoctor.view.MemberCenterInfoView;
import com.google.gooddoctor.view.MineOrderView;
import com.google.gooddoctor.view.SpringScrollView;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class NewMineTabFragment extends Fragment implements View.OnClickListener, MineAdapterNew.MineItemClickListener, MineOrderView.OnItemClickListener {

    public Context g;
    public TextView A;
	private View L;
    private RelativeLayout a;
    private ImageView G;
    public RelativeLayout R1;
    private View S;
    private TextView T;
    private View U;
    private RelativeLayout b;
	public FrameLayout D;
    public LinearLayout E;
    public int F = 0;
    public SpringScrollView H;
    public LinearLayout I;
    public TextView J;
	public MemberCenterInfoView M;
    private MineOrderView N;
    private RecyclerView O;
    private MineDaynicContent P;
	private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    public LinearLayout t;
    private LinearLayout u;
	private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    public TextView z;
    private LinearLayoutManager e;
    public String p = null;
    public int[] aa = {-86685, -359339};
    public ArrayList<Boolean> ab = null;
    private boolean o = false;
    int c;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.mine_layout, null);
        this.L = inflate;
        a(inflate);
        this.L.findViewById(R.id.v_status_placeholder).setVisibility(View.GONE);
        y();
        return inflate;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.g = context;
    }

    private void a(View view) {
        if (view != null) {
//            this.a = (RelativeLayout) view.findViewById(R.id.user_info_layout);
//            this.G = (ImageView) view.findViewById(R.id.iv_background_1);
//            this.R1 = (RelativeLayout) view.findViewById(R.id.topbar_setting);
//            this.R1.setOnClickListener(this);
//            this.R1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//                public boolean onPreDraw() {
//                    NewMineTabFragment.this.R1.getViewTreeObserver().removeOnPreDrawListener(this);
//                    return false;
//                }
//            });
//            this.S = view.findViewById(R.id.imgSettingTips);
//            this.b = (RelativeLayout) view.findViewById(R.id.topbar_msg);
//            this.b.setOnClickListener(this);
//            this.b.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//                public boolean onPreDraw() {
//                    NewMineTabFragment.this.b.getViewTreeObserver().removeOnPreDrawListener(this);
//                    return false;
//                }
//            });
//            this.T = (TextView) view.findViewById(R.id.topbar_msg_count);
//            this.U = view.findViewById(R.id.topbar_msg_tips);

			//数据/UI监听
//			this.f.b(this.U);
//			this.f.a(this.T);
//			this.f.a(this.S);

            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffFEAD63"), Color.parseColor("#ffFA8455")});
//            this.D = (FrameLayout) view.findViewById(R.id.fl_head);
            this.E = (LinearLayout) view.findViewById(R.id.ll_head);
            this.E.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (NewMineTabFragment.this.E.getHeight() != 0) {
                        NewMineTabFragment.this.F = NewMineTabFragment.this.E.getHeight();
                        StringBuilder sb = new StringBuilder();
                        sb.append("ll_head = ");
                        sb.append(NewMineTabFragment.this.F);
                    }
                    if (NewMineTabFragment.this.H != null) {
                        NewMineTabFragment.this.H.setheight(NewMineTabFragment.this.F);
                    }
                    if (NewMineTabFragment.this.D != null) {
                        NewMineTabFragment.this.D.setLayoutParams(new LinearLayout.LayoutParams(-1, NewMineTabFragment.this.F));
                    }
                    NewMineTabFragment.this.E.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
            this.E.setBackground(gradientDrawable);
            this.J = (TextView) view.findViewById(R.id.tv_mine_title);
            this.H = (SpringScrollView) view.findViewById(R.id.sv_mine);
            this.H.setScrollViewListener(new SpringScrollView.ScrollViewListener() {
                public void a(SpringScrollView springScrollView, int i, int i2, int i3, int i4) {
                    float a2 = ((float) i2) / ((float) DisplayUtil.a(springScrollView.getContext(), 44.0f));
                    float f = 1.0f;
                    if (a2 <= 1.0f) {
                        f = a2;
                    }
                    int argb = Color.argb((int) (255.0f * f), 255, 255, 255);
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{NewMineTabFragment.this.aa[0] & argb, argb & NewMineTabFragment.this.aa[1]});
                    gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                    NewMineTabFragment.this.I.setVisibility(View.VISIBLE);
                    NewMineTabFragment.this.I.setBackground(gradientDrawable);
                    NewMineTabFragment.this.J.setAlpha(f);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) DisplayUtil.b(NewMineTabFragment.this.getContext())) - ((float) (DisplayUtil.a(NewMineTabFragment.this.getContext(), 96.0f) * 2))), -1);
                    layoutParams.addRule(13);
                    NewMineTabFragment.this.J.setLayoutParams(layoutParams);
                    Log.d("DampScrollView", String.format("x = %s, y = %s ,oldx = %s, oldy = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
                }
            });
            this.I = (LinearLayout) view.findViewById(R.id.ll_mine_tile);
            this.I.setVisibility(View.GONE);
//            this.q = (LinearLayout) view.findViewById(R.id.ll_cash);
//            this.r = (LinearLayout) view.findViewById(R.id.gift_card);
//            this.s = (LinearLayout) view.findViewById(R.id.health_money);
//            this.u = (LinearLayout) view.findViewById(R.id.wallet);
//            this.t = (LinearLayout) view.findViewById(R.id.coupon);
//            this.t.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                public void onGlobalLayout() {
//                    NewMineTabFragment.this.c = NewMineTabFragment.this.t.getWidth();
//                    NewMineTabFragment.this.t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                }
//            });
//            this.q.setOnClickListener(this);
//            this.r.setOnClickListener(this);
//            this.s.setOnClickListener(this);
//            this.u.setOnClickListener(this);
//            this.t.setOnClickListener(this);
            this.M = (MemberCenterInfoView) view.findViewById(R.id.mine_membercenterinfo_view);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.argb(255, 255, 228, 180), Color.argb(255, 233, 192, 121)});
            gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable2.setCornerRadius((float) DisplayUtil.a(this.g, 8.0f));
            this.M.setBackground(gradientDrawable2);
            this.M.setSourcePage(this.p);
//            this.v = (TextView) view.findViewById(R.id.cash_number);
//            this.w = (TextView) view.findViewById(R.id.gift_card_number);
//            this.x = (TextView) view.findViewById(R.id.health_money_number);
//            this.y = (TextView) view.findViewById(R.id.wallet_number);
//            this.z = (TextView) view.findViewById(R.id.coupon_number);
//            this.A = (TextView) view.findViewById(R.id.tv_lable);
            this.N = (MineOrderView) view.findViewById(R.id.mine_order_view);
            this.N.setItemClickListener(this);
//            this.O = (RecyclerView) view.findViewById(R.id.rv_danymic_content);
//            this.O.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
//                    super.onScrollStateChanged(recyclerView, i);
//                    int findLastVisibleItemPosition = NewMineTabFragment.this.e.findLastVisibleItemPosition();
//                    if (i == 0) {
//                        for (int findFirstVisibleItemPosition = NewMineTabFragment.this.e.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
//                            View findViewByPosition = NewMineTabFragment.this.e.findViewByPosition(findFirstVisibleItemPosition);
//                            HashMap hashMap = new HashMap();
//                            hashMap.put("source", NewMineTabFragment.this.p);
////                            new MineDataBufferEventManager().a(findFirstVisibleItemPosition, NewMineTabFragment.this.ab, findViewByPosition, hashMap, false);
//                        }
//                    }
//                }
//
//                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
//                    super.onScrolled(recyclerView, i, i2);
//                    int scrollState = recyclerView.getScrollState();
//                    int findLastVisibleItemPosition = NewMineTabFragment.this.e.findLastVisibleItemPosition();
//                    if (scrollState == 0) {
//                        for (int findFirstVisibleItemPosition = NewMineTabFragment.this.e.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
//                            View findViewByPosition = NewMineTabFragment.this.e.findViewByPosition(findFirstVisibleItemPosition);
////                            RCBooth rCBooth = (RCBooth) NewMineTabFragment.this.C.value.get(findFirstVisibleItemPosition);
////                            if (rCBooth != null && TextUtils.equals(rCBooth.code, "APP_MINE_PROMOTION")) {
////                                HashMap hashMap = new HashMap();
////                                hashMap.put("source", NewMineTabFragment.this.p);
////                                new MineDataBufferEventManager().a(findFirstVisibleItemPosition, NewMineTabFragment.this.ab, findViewByPosition, hashMap, true);
////                            }
//                        }
//                    }
//                }
//            });
//            this.P = new MineDaynicContent(getContext(), this);
//            a(this.O, this.P);
        }
    }

	private void y() {
        if (Build.VERSION.SDK_INT >= 21) {
            View findViewById = this.L.findViewById(R.id.v_status_placeholder);
            findViewById.setVisibility(View.GONE);
            int systemUiVisibility = getActivity().getWindow().getDecorView().getSystemUiVisibility() & 1024;
            if (!getActivity().findViewById(R.id.main_layout).getFitsSystemWindows() && systemUiVisibility == 1024) {
                int height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
                this.E.setPadding(0, height, 0, 0);
                findViewById.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams2.height = height;
                findViewById.setLayoutParams(layoutParams2);
            }
        }
    }
	
	private void a(RecyclerView recyclerView, MineDaynicContent mineDaynicContent) {
//        this.e = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(this.e);
//        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(), 1));
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setItemAnimator(null);
//        recyclerView.setAdapter(mineDaynicContent);
    }


    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.coupon /*2131296644*/:
//                t();
//                return;
//            case R.id.gift_card /*2131296889*/:
//                o();
//                return;
//            case R.id.health_money /*2131296959*/:
//                p();
//                return;
//            case R.id.ll_cash /*2131297458*/:
//                u();
//                return;
//            case R.id.topbar_msg /*2131298437*/:
//                s();
//                return;
//            case R.id.topbar_setting /*2131298442*/:
//                r();
//                return;
//            case R.id.user_info_layout /*2131299030*/:
//                v();
//                return;
//            case R.id.wallet /*2131299095*/:
//                q();
//                return;
//            default:
//                return;
//        }
    }


    @Override
    public void a(String tag) {
        String url = "";
        switch (tag){
            case "gouwuche":
                url = "https://www.jk.cn/shop/#/cart";
                break;
            case "daifukuan":
                url = "https://www.jk.cn/yao-h5/home.html?app=pajk#yao-orderlist/waiting-pay";
                break;
            case "daishouhuo":
                url = "https://www.jk.cn/yao-h5/home.html?app=pajk#yao-orderlist/paid";
                break;
            case "daipingjia":
                url =  "https://www.jk.cn/yao-h5/home.html?app=pajk#yao-orderlist/comment";
                break;
            case "tuikuanshouhou":
                url = "https://www.jk.cn/yao-h5/home.html?app=pajk#yao-orderlist/after-sale";
                break;
            case "gengduodingdan":
                url="https://www.jk.cn/yao-h5/home.html?app=pajk#yao-orderlist/all";
                break;
            case "wdwenzhen":
                url = "https://www.jk.cn/dopamine/#/consultlist";
                break;
            case "wdyisheng":
                break;
            case "wdyongyao":
                url = "https://www.jk.cn/prescribe/#/myDrugSuggesion";
                break;
            case "wdtijian":
                url = "https://www.jk.cn/blossom/#/center?bType=phyexCenter&channel=2";
                break;
            case "wdguahao":
                url = "https://www.jk.cn/guahao/index.html#/book_list?business=wode";
                break;
            case "zhijiang1000":
                url = "https://www.jk.cn/shop/#/market/229866";
                break;
            case "100wanghongbao":
                url = "https://www.jk.cn/shop/?app=PAJK#/spree/home/231701";
                break;
            case "jiankangjindui":
                url = "https://www.jk.cn/shop/#/market/231031";
                break;
            case "888hongbao":
                url = "https://www.jk.cn/shop/?app=PAJK#/snapup/166865";
                break;
            case "sijiayisheng":
                url = "https://www.jk.cn/fe-genesis-cms/mobile/index.html#page/ph5-pdsales-10?channel=10&source=H5web_cms_185180_home";
                break;
            case "aixinli":
                break;
            case "muyingzhongxin":
                break;
            case "bubuduojin":
                url = "https://www.jk.cn/duojin-index/index.html?native_back_button_color=1&time=20171012";
                break;
            case "jiankangshuju":
                url = "https://www.jk.cn/health-data/index.html?app=pajk#/home";
                break;
            case "xianjinjiangli":
                url = "https://www.jk.cn/cash-invite/index.html#/home?bizCode=xj12&source=duojin";
                break;
            case "yaoqingyoujiang":
                break;
            case "wdshoucang":
                url = "https://www.jk.cn/mall-gather/?app=PAJK#/collection";
                break;
            case "wqzhibo":
                break;
            case "fankuishuju":
                url = "https://www.jk.cn/im-cs-m/#/im/23369050408?status=1";
                break;
            case "yaoqianhua":
                url = "https://wallet.xiaoying.com/fe/wallet-landing/blueRegPage/index.html?landId=1420&source=1000890860";
                break;
            case "bubuying":
                url = "https://www.jk.cn/bubuying/#/?app=PAJK&entry=duojin";
                break;
            case "jiufujiedai":
                url = "https://wanka.9fbank.com/actives/#/landingRegister";
                break;
            case "360jiadai":
                url = "https://mkt.xjietiao.com/activity/ch/pinganhys/pahsy1";
                break;
            case "youqianhua":
                url = "https://icash.baidu.com/cloan/operation/activity?activityName=channelBrand&CH=jmall&fr=JrkuD";
                break;
            default:
                break;
        }
        if(!TextUtils.isEmpty(url)) {
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        }
    }

    public void a(boolean z2, String str) {
        this.o = z2;
        this.p = str;
    }

    @Override
    public void a(int i, List list) {

    }

    @Override
    public void a(View view, Object obj, String str) {

    }

}