package com.google.gooddoctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gooddoctor.R;
import com.google.gooddoctor.view.PtrAnimationFrameLayout;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class ZkmzActivity extends Activity {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    private RecyclerView recyclerview;
    private ZkmzRecyclerviewAdapter zkmzRecyclerviewAdapter;
    private View mHeaderView;
    private List<String> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zkmz);
        recyclerview = findViewById(R.id.recyclerview);
        mList = new ArrayList<>();
        for(int i=0;i<20;i++){mList.add(""+i);}
        zkmzRecyclerviewAdapter = new ZkmzRecyclerviewAdapter();
        View headview = LayoutInflater.from(this).inflate(R.layout.item_zkmz_header, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        headview.setLayoutParams(layoutParams);
        zkmzRecyclerviewAdapter.setHeaderView(headview);
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.white_bg_divider));
        recyclerview.addItemDecoration(divider);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(zkmzRecyclerviewAdapter);
        final PtrAnimationFrameLayout ptrAnimationFrameLayout = findViewById(R.id.ptrFrameLayout);
        ptrAnimationFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrAnimationFrameLayout.refreshComplete();
                    }
                }, 3000);
            }
        });
        findViewById(R.id.layout_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(getIntent()!=null){
            String tag = getIntent().getStringExtra("tag");
            if(!TextUtils.isEmpty(tag)){
                TextView tv = findViewById(R.id.tvTitle);
                switch (tag){
                    case "pfk":
                        tv.setText("皮肤科");
                        break;
                    case "fck":
                        tv.setText("妇产科");
                        break;
                    case "ek":
                        tv.setText("儿科");
                        break;
                    case "pnk":
                        tv.setText("普内科");
                        break;
                    case "pwk":
                        tv.setText("普外科");
                        break;
                    case "zyk":
                        tv.setText("中医科");
                        break;
                    case "xhnk":
                        tv.setText("消化内科");
                        break;
                    case "gk":
                        tv.setText("骨科");
                        break;
                    case "mnwk":
                        tv.setText("泌尿外科");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    class ZkmzRecyclerviewAdapter extends RecyclerView.Adapter<ZkmzViewHodler>{

        public void setHeaderView(View headerView) {
            mHeaderView = headerView;
        }

        @Override
        public int getItemViewType(int position) {
            if(position == 0){
                return TYPE_HEADER;
            }
            return TYPE_NORMAL;
        }

        @NonNull
        @Override
        public ZkmzViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            if(getItemViewType(i) == TYPE_HEADER){
                return new ZkmzViewHodler(mHeaderView);
            }else {
                return new ZkmzViewHodler(LayoutInflater.from(ZkmzActivity.this).inflate(R.layout.item_zmmz_doctor, null));
            }
        }

        @Override
        public void onBindViewHolder(@NonNull ZkmzViewHodler zkmzViewHodler, int i) {
            if(getItemViewType(i) == TYPE_HEADER){

            }else{
//                zkmzViewHodler.textview.setText(mList.get(i));
            }
        }

        @Override
        public int getItemCount() {
            if(mHeaderView == null){
                return mList.size();
            }else {
                return mList.size() + 1;
            }
        }
    }

    class ZkmzViewHodler extends RecyclerView.ViewHolder {

        TextView textview;

        public ZkmzViewHodler(@NonNull View itemView) {
            super(itemView);
            if(itemView != mHeaderView){
//                textview = (TextView)itemView.findViewById(R.id.textview);
            }
        }

    }

}
