package com.google.gooddoctor.adapter;

import android.view.ViewGroup;
import java.util.List;

public class MainPageAdapter extends RecyclerViewAdapter {

    public MainPageAdapter(List list) {
        super(list);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        super.onBindViewHolder(baseViewHolder, i);
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public void a(List list) {
        getDatas().clear();
        getDatas().addAll(list);
        notifyDataSetChanged();
    }
}