package com.google.gooddoctor.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {
    
    public static void a(Context context, ImageView imageView, String str, int i) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.fitCenter().format(DecodeFormat.PREFER_RGB_565).disallowHardwareConfig().placeholder(i);
        Glide.with(context).load(str).apply(requestOptions).into(imageView);
    }

    public static void a(Context context, ImageView imageView, String str, int i, int i2) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.fitCenter().format(DecodeFormat.PREFER_RGB_565).disallowHardwareConfig().placeholder(i).error(i2);
        Glide.with(context).load(str).apply(requestOptions).into(imageView);
    }

    public static void a(Context context, ImageView imageView, String str, RequestOptions requestOptions) {
        Glide.with(context).load(str).apply(requestOptions).into(imageView);
    }

    public static void a(Context context, ImageView imageView, String str, RequestOptions requestOptions, RequestListener requestListener) {
        Glide.with(context).load(str).listener(requestListener).apply(requestOptions).into(imageView);
    }
}
