package com.google.gooddoctor.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.google.gooddoctor.adapter.BaseViewHolder;
import java.util.List;

public class DefaultDelegate extends BaseDelegate<BaseModuleItem, DefaultDelegate.ViewHolder> {

    public class ViewHolder extends BaseViewHolder<View> {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public DefaultDelegate(Context context) {
        super(context);
    }

    @NonNull
    public ViewHolder onCreateItemViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(new View(this.a));
    }

    public void onBindItemViewHolder(ViewHolder viewHolder, List<BaseModuleItem> list, int i) {
        viewHolder.itemView.setVisibility(View.GONE);
    }

}