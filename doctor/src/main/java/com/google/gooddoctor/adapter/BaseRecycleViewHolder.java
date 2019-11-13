package com.google.gooddoctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class BaseRecycleViewHolder extends ViewHolder implements OnClickListener {

    protected Context a;
    protected View b;

    public BaseRecycleViewHolder(View view) {
        super(view);
        this.b = view;
    }

}
