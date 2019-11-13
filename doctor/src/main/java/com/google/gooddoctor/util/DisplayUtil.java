package com.google.gooddoctor.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DisplayUtil {
    public static DisplayMetrics a(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int a(Context context, float f) {
        return (int) (TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int b(Context context, float f) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.density != 0.0f) {
            return (int) ((f / displayMetrics.density) + 0.5f);
        }
        return 0;
    }
}