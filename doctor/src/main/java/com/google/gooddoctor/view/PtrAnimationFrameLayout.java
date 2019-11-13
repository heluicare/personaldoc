package com.google.gooddoctor.view;

import android.content.Context;
import android.util.AttributeSet;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class PtrAnimationFrameLayout extends PtrFrameLayout {

    PtrAnimationHeader mHeaderView;

    public PtrAnimationFrameLayout(Context context) {
        super(context);
        initView();
    }

    public PtrAnimationFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PtrAnimationFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        mHeaderView = new PtrAnimationHeader(getContext());
        setHeaderView(mHeaderView);
        addPtrUIHandler(mHeaderView);
    }

}