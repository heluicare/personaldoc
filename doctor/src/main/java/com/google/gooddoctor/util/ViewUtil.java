package com.google.gooddoctor.util;

import android.app.Activity;
import android.view.View;

public class ViewUtil {
    public static <T extends View> T a(Activity activity, int i) {
        try {
            return activity.findViewById(i);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not find the view by id:");
            sb.append(i);
            throw new NullPointerException(sb.toString());
        }
    }

    public static <T extends View> T a(View view, int i) {
        try {
            return view.findViewById(i);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not find the view by id:");
            sb.append(i);
            throw new NullPointerException(sb.toString());
        }
    }

    public static int a(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    public static int b(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return view.getMeasuredHeight();
    }
}
