package com.google.gooddoctor.adapter;

import android.view.View;
import java.util.List;

public abstract class ResizeBaseViewHolder<CV extends View, DATA> extends BaseViewHolder<CV> {

    public void a(CV cv) {
    }

    public void a(DATA data) {
    }

    public void a(DATA data, int i) {
    }

    public ResizeBaseViewHolder(CV cv) {
        super(cv);
        a(cv);
    }

    public void a(List<DATA> list, int i) {
        Object obj = list.get(i);
        a((DATA) obj, i);
        a((DATA) obj);
    }

}