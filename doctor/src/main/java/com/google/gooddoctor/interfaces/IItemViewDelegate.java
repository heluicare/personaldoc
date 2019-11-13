package com.google.gooddoctor.interfaces;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.google.gooddoctor.adapter.BaseViewHolder;
import java.util.List;

public interface IItemViewDelegate<T extends IItemInfo, VH extends BaseViewHolder> {
    void onBindItemViewHolder(VH vh, List<T> list, int i);

    @NonNull
    VH onCreateItemViewHolder(ViewGroup viewGroup);

}