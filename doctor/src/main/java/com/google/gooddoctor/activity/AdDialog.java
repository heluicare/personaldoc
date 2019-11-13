package com.google.gooddoctor.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.google.gooddoctor.R;

public class AdDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public AdDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        layout();
    }

    public AdDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        layout();
    }

    protected AdDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        layout();
    }

    private void layout(){
        setContentView(R.layout.addialog);
        //一定要在setContentView之后调用，否则无效
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        findViewById(R.id.close_layout).setOnClickListener(this);
        findViewById(R.id.imgview).setOnClickListener(this);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close_layout:
                dismiss();
                break;
            case R.id.imgview:
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", "https://www.jk.cn/shop/#/market/205515");
                context.startActivity(intent);
                dismiss();
                break;
            default:
                break;
        }
    }


}
