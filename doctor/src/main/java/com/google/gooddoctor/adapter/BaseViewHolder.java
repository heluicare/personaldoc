package com.google.gooddoctor.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class BaseViewHolder<CV extends View> extends ViewHolder {

    public BaseViewHolder(CV cv) {
        super(cv);
    }

    public CV findView(@NonNull View view, int i) {
        return view.findViewById(i);
    }

}