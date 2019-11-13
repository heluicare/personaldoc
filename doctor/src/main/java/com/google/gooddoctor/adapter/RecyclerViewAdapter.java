package com.google.gooddoctor.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.interfaces.IItemViewDelegate;
import com.google.gooddoctor.util.DelegateManager;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter<T extends IItemInfo> extends Adapter<BaseViewHolder> {
    private DelegateManager<T, BaseViewHolder, IItemViewDelegate> delegateManager;
    private List mList;

    public RecyclerViewAdapter(List list) {
        this.mList = list;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.delegateManager.a(viewGroup, i);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        this.delegateManager.a(baseViewHolder, this.mList, i);
    }

    public int getItemViewType(int i) {
        IItemInfo iItemInfo = (IItemInfo) this.mList.get(i);
        if (iItemInfo != null) {
            return this.delegateManager.a((T) iItemInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getItemViewType()---> itemInfo maybe not null, position=");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public int getItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    public void setDelegateManager(DelegateManager<T, BaseViewHolder, IItemViewDelegate> delegateManager2) {
        this.delegateManager = delegateManager2;
    }

    public DelegateManager<T, BaseViewHolder, IItemViewDelegate> getDelegateManager() {
        return this.delegateManager;
    }

    public List<T> getDatas() {
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        return this.mList;
    }
}