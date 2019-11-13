package com.google.gooddoctor.util;


import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.interfaces.ViewStatus;

public abstract class BaseModuleItem<T> implements ViewStatus, IItemInfo {
    protected T mModuleItemData;
    protected int mViewStatus = 1;

    public BaseModuleItem(T t) {
        this.mModuleItemData = t;
    }

    public void onViewStatusChange(int i) {
        this.mViewStatus = i;
    }

    public int getViewStatus() {
        return this.mViewStatus;
    }

    public T getModuleItemData() {
        return this.mModuleItemData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseModuleItem{mViewStatus=");
        sb.append(this.mViewStatus);
        sb.append(", mModuleItemData=");
        sb.append(this.mModuleItemData);
        sb.append('}');
        return sb.toString();
    }
}

