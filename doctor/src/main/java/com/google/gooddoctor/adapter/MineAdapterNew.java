package com.google.gooddoctor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.util.PtrCLog;
import com.google.gooddoctor.view.MemberCenterInfoView;

import java.util.ArrayList;
import java.util.List;

public class MineAdapterNew extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String a = "MineAdapterNew";
    private Context b;
    public String c = null;
    public List<List<MemberCenterInfoView.MemberData>> d;
    public MineItemClickListener e;
    private int f = -10066330;
    private int g = -3355444;

    public interface MineItemClickListener {
        void a(int i, List list);
        void a(View view, Object obj, String str);
    }

    public interface ViewClickListener {
        void a(View view, int i);
    }

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        ImageView c;
        View d;
        LinearLayout e;
        RelativeLayout f;

        public ViewHolder(@NonNull View view, final ViewClickListener viewClickListener) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.mine_item_name);
            this.b = (TextView) view.findViewById(R.id.mine_item_subname);
            this.d = view.findViewById(R.id.ci_tips);
            this.c = (ImageView) view.findViewById(R.id.mine_item_icon);
            this.f = (RelativeLayout) view.findViewById(R.id.rl_icon);
            this.e = (LinearLayout) view.findViewById(R.id.mine_adapter_layout);
            this.e.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (viewClickListener != null) {
                        viewClickListener.a(ViewHolder.this.a, ViewHolder.this.getAdapterPosition());
                    }
                }
            });
        }
    }

    public MineAdapterNew(Context context, List list, MineItemClickListener mineItemClickListener, boolean z) {
        this.b = context;
        this.d = list;
        this.e = mineItemClickListener;
        this.c = null;
    }

    public void a(List<List<MemberCenterInfoView.MemberData>> list) {
        this.d = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PtrCLog.b(a + " onCreateViewHolder...");
        if (this.b == null) {
            return null;
        }
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mine_item_layout_linear, null), new ViewClickListener() {
            public void a(View view, int i) {
                if (MineAdapterNew.this.d != null && MineAdapterNew.this.d.size() >= i + 1 && i >= 0 && MineAdapterNew.this.e != null) {
                    MineAdapterNew.this.e.a(view, MineAdapterNew.this.d.get(i), MineAdapterNew.this.c);
                }
            }
        });

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PtrCLog.b(a + " onBindViewHolder...");
        ViewHolder vh = (ViewHolder) viewHolder;
        for (List<MemberCenterInfoView.MemberData> l : this.d){
            for (MemberCenterInfoView.MemberData m : l){
                vh.a.setText(m.a);
                if(!TextUtils.isEmpty(m.b)) {
                    vh.b.setText(m.b);
                }
                if(m.e > 0) {
                    vh.c.setImageDrawable(b.getResources().getDrawable(m.e));
                }
            }
        }
    }


    public int getItemCount() {
        if (this.d == null) {
            return 0;
        }
        return this.d.get(0).size();
    }

}
