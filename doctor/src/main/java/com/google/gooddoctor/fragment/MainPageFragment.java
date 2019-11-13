package com.google.gooddoctor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gooddoctor.R;
import com.google.gooddoctor.activity.MainActivity;
import com.google.gooddoctor.activity.WebActivity;
import com.google.gooddoctor.activity.ZkmzActivity;
import com.google.gooddoctor.util.DisplayUtil;
import com.google.gooddoctor.view.PtrAnimationFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainPageFragment extends Fragment implements View.OnClickListener {

    private RecyclerView f;
    public PtrAnimationFrameLayout o;
//    public MainPageAdapter p;
//    public MPMedicalNewsDelegate r;
//    private PDHealthManagerDelegate t;
	
	public static MainPageFragment a(String str, int i) {
        MainPageFragment medicalMainPageFragment = new MainPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab_name", str);
        bundle.putInt("bg_color", i);
        medicalMainPageFragment.setArguments(bundle);
        return medicalMainPageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.medical_main_page_v2, null);
        a(inflate);
        return inflate;
    }

    private void a(View view) {
//        DelegateManager i = i();
//        this.f = (RecyclerView) view.findViewById(R.id.main_recycler);
//        this.p = new MainPageAdapter(new ArrayList());
//        this.p.setDelegateManager(i);
//        this.f.setAdapter(this.p);
//        this.p.a(new ArrayList());
        this.o = view.findViewById(R.id.ptr_layout);
        this.o.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        o.refreshComplete();
                    }
                }, 3000);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.topMargin = DisplayUtil.a(getActivity(), 46) + getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        this.o.setLayoutParams(layoutParams);
        //顶部广告
        view.findViewById(R.id.img_top_ad).setOnClickListener(this);
        //快速问诊
        view.findViewById(R.id.layout_kswz).setOnClickListener(this);
        view.findViewById(R.id.layout_zmy).setOnClickListener(this);
        view.findViewById(R.id.layout_xfky).setOnClickListener(this);
        //专科门诊
        view.findViewById(R.id.layout_pfk).setOnClickListener(this);
        view.findViewById(R.id.layout_fck).setOnClickListener(this);
        view.findViewById(R.id.layout_ek).setOnClickListener(this);
        view.findViewById(R.id.layout_pnk).setOnClickListener(this);
        view.findViewById(R.id.layout_pwk).setOnClickListener(this);
        view.findViewById(R.id.layout_zyk).setOnClickListener(this);
        view.findViewById(R.id.layout_xhnk).setOnClickListener(this);
        view.findViewById(R.id.layout_gk).setOnClickListener(this);
        view.findViewById(R.id.layout_mnwk).setOnClickListener(this);
        view.findViewById(R.id.layout_zkmz_more).setOnClickListener(this);
        //中医馆
        view.findViewById(R.id.ll_jkys).setOnClickListener(this);
        view.findViewById(R.id.ll_rmmf).setOnClickListener(this);
        view.findViewById(R.id.ll_wang).setOnClickListener(this);
        view.findViewById(R.id.ll_wenn).setOnClickListener(this);
        view.findViewById(R.id.ll_wen).setOnClickListener(this);
        view.findViewById(R.id.ll_qie).setOnClickListener(this);
//        this.f.setLayoutManager(new LinearLayoutManager(getActivity()));
//        this.f.setAdapter(new HomeAdapter());

//        Typeface type = Typeface.createFromAsset(view.getContext().getAssets(), "gotham_rnd_medium.ttf");
//        TextView tv_zkmz = (TextView) view.findViewById(R.id.tv_zkmz);
//        tv_zkmz.setTypeface(type);
//        TextView tv_zyg = (TextView) view.findViewById(R.id.tv_zyg);
//        tv_zyg.setTypeface(type);
    }

    @Override
    public void onClick(View v) {
        String url = "";
        String tag = "";
        switch (v.getId()){
            case R.id.layout_kswz:
                Toast.makeText(getActivity(), "快速问诊", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_zmy:
                ((MainActivity)getActivity()).a(1);
                break;
            case R.id.layout_pfk:
                tag = "pfk";
                break;
            case R.id.layout_fck:
                tag = "fck";
                break;
            case R.id.layout_ek:
                tag = "ek";
                break;
            case R.id.layout_pnk:
                tag = "pnk";
                break;
            case R.id.layout_pwk:
                tag = "pwk";
                break;
            case R.id.layout_zyk:
                tag = "zyk";
                break;
            case R.id.layout_xhnk:
                tag = "xhnk";
                break;
            case R.id.layout_gk:
                tag = "gk";
                break;
            case R.id.layout_mnwk:
                tag = "mnwk";
                break;
            case R.id.img_top_ad:
                url = "https://www.jk.cn/fe-genesis-cms/mobile/index.html?channel=1080#/page/ph5-med-2";
                break;
            case R.id.layout_xfky:
                url = "https://www.jk.cn/shop/#/market/110338";
                break;
            case R.id.layout_zkmz_more:
                url = "https://www.jk.cn/shop/#/market/92032";
                break;
            case R.id.ll_jkys:
                url = "https://www.jk.cn/shop/#/market/229094";
                break;
            case R.id.ll_rmmf:
                url = "https://www.jk.cn/shop/#/market/228882";
                break;
            case R.id.ll_wang:
                url = "https://www.jk.cn/shop/#/market/228156";
                break;
            case R.id.ll_wenn:
                url = "https://www.jk.cn/shop/#/market/230686";
                break;
            case R.id.ll_wen:
                url = "https://www.jk.cn/shop/#/market/228150";
                break;
            case R.id.ll_qie:
                url = "https://www.jk.cn/shop/#/market/228158";
                break;
            default:
                break;
        }
        if(!TextUtils.isEmpty(url)){
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        }
        if(!TextUtils.isEmpty(tag)){
            Intent intent = new Intent(getActivity(), ZkmzActivity.class);
            intent.putExtra("tag", tag);
            startActivity(intent);
        }
    }

//    private DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> i() {
//        DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> a2 = MedicalDelegateManagerProvider.a(getActivity());
////        this.r = new MPMedicalNewsDelegate(getActivity(), this, this.v);
////        MedicalDelegateManagerProvider.a(a2, 108, this.r);
////        this.t = new PDHealthManagerDelegate(getActivity());
////        MedicalDelegateManagerProvider.a(a2, 105, this.t);
//        return a2;
//    }


}