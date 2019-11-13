package com.google.gooddoctor.util;

import android.content.Context;

import com.google.gooddoctor.adapter.BaseViewHolder;
import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.interfaces.IItemViewDelegate;

public abstract class BaseDelegate<T extends IItemInfo, VH extends BaseViewHolder> implements IItemViewDelegate<T, VH> {
    protected Context a;

    public BaseDelegate(Context context) {
        this.a = context;
    }
}
