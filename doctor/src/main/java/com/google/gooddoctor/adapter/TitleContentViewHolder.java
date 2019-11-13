package com.google.gooddoctor.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gooddoctor.R;
import com.google.gooddoctor.view.GridRecyclerViewDivider;
import java.util.ArrayList;
import java.util.List;

public class TitleContentViewHolder extends BaseRecycleViewHolder {
    LinearLayout c;
    protected List d = new ArrayList();
    private MineAdapterNew e;
    private TextView f;
    private RecyclerView g;
    private LinearLayout h;
    private final int i;
    private int j;
    public int k;

    public void onClick(View view) {
    }

    public TitleContentViewHolder(Context context, View view, final MineAdapterNew.MineItemClickListener mineItemClickListener, int i2, int i3) {
        super(view);
        int i4 = 5;
        this.i = 5;
        this.j = 0;
        this.k = 0;
        this.a = context;
        this.j = i3;
        this.c = (LinearLayout) this.b.findViewById(R.id.ll_mine_content);
        this.f = (TextView) this.b.findViewById(R.id.tv_mine_dynamic_title);
        this.h = (LinearLayout) this.b.findViewById(R.id.ll_more);
        this.h.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mineItemClickListener != null) {
                    mineItemClickListener.a(TitleContentViewHolder.this.k, TitleContentViewHolder.this.d);
                }
            }
        });
        this.g = (RecyclerView) this.b.findViewById(R.id.rv_content);
        this.e = new MineAdapterNew(this.a, null, mineItemClickListener, false);
        if (i2 > 0) {
            i4 = i2;
        }
        this.g.setLayoutManager(new GridLayoutManager(this.a, i4));
        GridRecyclerViewDivider gridRecyclerViewDivider = new GridRecyclerViewDivider(this.a, false);
        gridRecyclerViewDivider.setDividerHeight(0, 0);
        this.g.addItemDecoration(gridRecyclerViewDivider);
        this.g.setHasFixedSize(false);
        this.g.setItemAnimator(null);
        this.g.setAdapter(this.e);
    }

    public void a(List list, int i2, String str) {
        if (list != null && list.size() != 0 && list.size() > i2) {
            this.e.a(list);
        }
    }

}
