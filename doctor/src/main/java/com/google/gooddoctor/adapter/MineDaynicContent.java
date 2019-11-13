package com.google.gooddoctor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gooddoctor.R;
import com.google.gooddoctor.util.PtrCLog;
import com.google.gooddoctor.view.MemberCenterInfoView;

import java.util.ArrayList;
import java.util.List;

public class MineDaynicContent extends RecyclerView.Adapter<BaseRecycleViewHolder> {

    protected List<List<MemberCenterInfoView.MemberData>> a = new ArrayList();
    protected List b = new ArrayList();
    protected Context c;
    private MineAdapterNew.MineItemClickListener d;

    public void a() {
    }

    public MineDaynicContent(Context context, MineAdapterNew.MineItemClickListener mineItemClickListener) {
        this.c = context;
        this.d = mineItemClickListener;
    }

    @NonNull
    @Override
    public BaseRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PtrCLog.b("MineDaynicContent onCreateViewHolder...");
        if (i == MineType.ITEM_TYPE_TITLE_CONTENT.ordinal()) {
            TitleContentViewHolder titleContentViewHolder = new TitleContentViewHolder(this.c, LayoutInflater.from(this.c).inflate(R.layout.mine_title_content, viewGroup, false), this.d, 5, 1);
            return titleContentViewHolder;
        } else if (i == MineType.ITEM_TYPE_TITLE_CONTENT_NOMORE.ordinal()) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.mine_title_content, viewGroup, false);
            ((LinearLayout) inflate.findViewById(R.id.ll_more)).setVisibility(View.GONE);
            TitleContentViewHolder titleContentViewHolder2 = new TitleContentViewHolder(this.c, inflate, this.d, 5, 2147483646);
            return titleContentViewHolder2;
        } else if (i == MineType.ITEM_TYPE_TITLE_CONTENT_NOTITLE.ordinal()) {
            View inflate2 = LayoutInflater.from(this.c).inflate(R.layout.mine_title_content, viewGroup, false);
            ((RelativeLayout) inflate2.findViewById(R.id.rl_title)).setVisibility(View.GONE);
            TitleContentViewHolder titleContentViewHolder3 = new TitleContentViewHolder(this.c, inflate2, this.d, 4, 1);
            return titleContentViewHolder3;
        } else if (i != MineType.ITEM_TYPE_TITLE_CONTENT_NOTITLE_CUSTOMGROUND.ordinal()) {
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.c).inflate(R.layout.mine_backgound_title_content, viewGroup, false);
            ((RelativeLayout) inflate3.findViewById(R.id.rl_title)).setVisibility(View.GONE);
            TitleBackGroundContentViewHolder titleBackGroundContentViewHolder = new TitleBackGroundContentViewHolder(this.c, inflate3, this.d, 4, 1);
            return titleBackGroundContentViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecycleViewHolder baseRecycleViewHolder, int i) {
        PtrCLog.b("MineDaynicContent onBindViewHolder...");
        if (baseRecycleViewHolder instanceof TitleContentViewHolder) {
            if (this.a != null && this.a.size() != 0 && this.a.size() > i) {
                if (getItemViewType(i) == MineType.ITEM_TYPE_TITLE_CONTENT_NOMORE.ordinal()) {
                    if (i == this.a.size() - 1) {
                        ((TitleContentViewHolder) baseRecycleViewHolder).b.setLayoutParams(new LayoutParams(-1, -1));
                    } else {
                        ((TitleContentViewHolder) baseRecycleViewHolder).b.setLayoutParams(new LayoutParams(-1, -2));
                    }
                }
                ((TitleContentViewHolder) baseRecycleViewHolder).a(this.a, i, "");
            }
        } else if (baseRecycleViewHolder instanceof TitleBackGroundContentViewHolder) {
            ((TitleBackGroundContentViewHolder) baseRecycleViewHolder).a(this.a, i, "");
        }
    }

    public int getItemCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public int getItemViewType(int i) {
        return (this.a == null || this.a.size() == 0) ? super.getItemViewType(i) : MineType.ITEM_TYPE_TITLE_CONTENT.ordinal();//(this.a.get(i)).b.ordinal();
    }

    public void a(List<List<MemberCenterInfoView.MemberData>> list) {
        if (list != null && list.size() != 0) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

}
