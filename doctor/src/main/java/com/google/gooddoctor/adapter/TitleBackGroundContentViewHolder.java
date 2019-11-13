package com.google.gooddoctor.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gooddoctor.R;
import com.google.gooddoctor.view.GridRecyclerViewDivider;
import com.google.gooddoctor.view.RoundCornerImageView;
import java.util.ArrayList;
import java.util.List;

public class TitleBackGroundContentViewHolder extends BaseRecycleViewHolder {
    LinearLayout c;
    FrameLayout d;
    protected List e = new ArrayList();
    private MineAdapterNew f;
    private TextView g;
    public RecyclerView h;
    public RoundCornerImageView i;
    private LinearLayout j;
    private int k = 5;
    private int l = 0;
    public int m = 0;

    public void onClick(View view) {
    }

    public TitleBackGroundContentViewHolder(Context context, View view, final MineAdapterNew.MineItemClickListener mineItemClickListener, int i2, int i3) {
        super(view);
        this.a = context;
        this.l = i3;
        this.k = i2;
        this.d = (FrameLayout) this.b.findViewById(R.id.fl_mine_title);
        this.i = (RoundCornerImageView) this.b.findViewById(R.id.iv_background);
        this.c = (LinearLayout) this.b.findViewById(R.id.ll_mine_content);
        this.g = (TextView) this.b.findViewById(R.id.tv_mine_dynamic_title);
        this.j = (LinearLayout) this.b.findViewById(R.id.ll_more);
        this.j.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mineItemClickListener != null) {
                    mineItemClickListener.a(TitleBackGroundContentViewHolder.this.m, TitleBackGroundContentViewHolder.this.e);
                }
            }
        });
        this.h = (RecyclerView) this.b.findViewById(R.id.rv_content);
        this.f = new MineAdapterNew(this.a, null, mineItemClickListener, false);
        if (i2 <= 0) {
            i2 = this.k;
        }
        this.h.setLayoutManager(new GridLayoutManager(this.a, i2));
        GridRecyclerViewDivider gridRecyclerViewDivider = new GridRecyclerViewDivider(this.a, false);
        gridRecyclerViewDivider.setDividerHeight(0, 0);
        this.h.addItemDecoration(gridRecyclerViewDivider);
        this.h.setHasFixedSize(false);
        this.h.setItemAnimator(null);
        this.h.setAdapter(this.f);
    }

    public void a(List list, int i2, String str) {
//        if (list != null && list.size() != 0 && list.size() > i2) {
//            RCBooth rCBooth = (RCBooth) ((MineItemEntry) list.get(i2)).a;
//            if (rCBooth != null) {
//                this.e = list;
//                this.m = i2;
//                this.g.setText(rCBooth.name);
//                if (rCBooth != null) {
//                    if (!TextUtils.isEmpty(rCBooth.imgUrl)) {
//                        Glide.with(this.a).load(ImageUtils.getThumbnailFullPath(rCBooth.imgUrl, "")).listener(new RequestListener<Drawable>() {
//                            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
//                                TitleBackGroundContentViewHolder.this.b.setBackgroundResource(R.color.mine_floor_background_default_color);
//                                TitleBackGroundContentViewHolder.this.c.setBackgroundResource(R.drawable.circle_radius_ffffff_tras);
//                                return false;
//                            }
//
//                            /* renamed from: a */
//                            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
//                                TitleBackGroundContentViewHolder.this.h.setBackgroundColor(0);
//                                TitleBackGroundContentViewHolder.this.c.setBackgroundColor(0);
//                                float a2 = (float) DisplayUtil.a(TitleBackGroundContentViewHolder.this.a, 6.0f);
//                                TitleBackGroundContentViewHolder.this.i.a(a2, a2, a2, a2);
//                                TitleBackGroundContentViewHolder.this.i.invalidate();
//                                return false;
//                            }
//                        }).into((ImageView) this.i);
//                    }
//                    if (this.l == 0) {
//                        this.f.a(rCBooth);
//                        return;
//                    }
//                    RCBooth rCBooth2 = new RCBooth();
//                    rCBooth2.code = rCBooth.code;
//                    rCBooth2.name = rCBooth.name;
//                    rCBooth2.showcases = new ArrayList();
//                    List<RCShowcase> list2 = rCBooth.showcases;
//                    if (list2.size() > this.l * this.k) {
//                        if (list2 != null) {
//                            for (int i3 = 0; i3 < this.k; i3++) {
//                                rCBooth2.showcases.add(rCBooth.showcases.get(i3));
//                            }
//                        }
//                        this.f.a(rCBooth2);
//                    } else {
//                        this.f.a(rCBooth);
//                    }
//                }
//            }
//        }
    }

}
