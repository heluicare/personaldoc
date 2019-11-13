package com.google.gooddoctor.util;

import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.view.ViewGroup;
import com.google.gooddoctor.adapter.BaseViewHolder;
import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.interfaces.IItemViewDelegate;
import java.util.List;

public class DelegateManager<T extends IItemInfo, VH extends BaseViewHolder, D extends IItemViewDelegate> {
    
    private final SparseArrayCompat<D> a = new SparseArrayCompat<>();

    public DelegateManager a(int i, D d) {
        this.a.put(i, d);
        return this;
    }

    public VH a(ViewGroup viewGroup, int i) {
        IItemViewDelegate iItemViewDelegate = (IItemViewDelegate) this.a.get(i);
        if (iItemViewDelegate != null) {
            return (VH) iItemViewDelegate.onCreateItemViewHolder(viewGroup);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onCreateViewHolder()--->: viewType=");
        sb.append(i);
        Log.w("DelegateManager", sb.toString());
        return null;
    }

    public void a(VH vh, List<T> list, int i) {
        int itemViewType = vh.getItemViewType();
        IItemViewDelegate iItemViewDelegate = (IItemViewDelegate) this.a.get(itemViewType);
        if (iItemViewDelegate == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onBindViewHolder()--->: viewType=");
            sb.append(itemViewType);
            Log.w("DelegateManager", sb.toString());
            return;
        }
        iItemViewDelegate.onBindItemViewHolder(vh, list, i);
    }

    public int a(T t) {
        if (t == null) {
            Log.w("DelegateManager", "getItemViewType()--->: t maybe not null!");
            return -1;
        }
        int delegateType = t.getDelegateType();
        if (this.a.get(delegateType) == null) {
            return -1;
        }
        return delegateType;
    }
}
