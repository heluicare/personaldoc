package com.google.gooddoctor.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gooddoctor.R;
import com.google.gooddoctor.adapter.BaseViewHolder;
import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.util.BaseDelegate;
import java.util.List;

public class MedicalWenZhenDelegate extends BaseDelegate<IItemInfo, MedicalWenZhenDelegate.ViewHolder> {

    static class ViewHolder extends BaseViewHolder<View> {

        public ViewHolder(View view) {
            super(view);
        }
    }

    public MedicalWenZhenDelegate(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.medical_wenzhen_view, viewGroup, false));
    }

    @Override
    public void onBindItemViewHolder(ViewHolder viewHolder, List<IItemInfo> list, int i) {

    }

}
