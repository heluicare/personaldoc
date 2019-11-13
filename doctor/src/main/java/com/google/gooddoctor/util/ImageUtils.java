package com.google.gooddoctor.util;

import android.text.TextUtils;
import android.util.Log;

public class ImageUtils {
    public static String getSmallImageSize() {
        return "120x120";
    }

    public static String getImageFullUrl(String str) {
        if (str.toLowerCase().startsWith("http") || str.toLowerCase().startsWith("https")) {
            return str;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("file:")) {
            return str;
        }
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().endsWith(".gif")) {
            return getThumbnailFullPathWithFormat(str, null);
        }
        StringBuilder sb = new StringBuilder();
//        sb.append(ContextHelper.mImageUrl);
        sb.append(str);
        sb.append("_1200x1200.png");
        return sb.toString();
    }

    public static String getResourceFullUrl(String str) {
        if (str.toLowerCase().startsWith("http") || str.toLowerCase().startsWith("https")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
//        sb.append(ContextHelper.mImageUrl);
        sb.append(str);
        return sb.toString();
    }

    @Deprecated
    public static String getThumbnailFullPath(String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            Log.e("ImageUtils检测", "空");
            return "";
        } else if (TextUtils.isEmpty(str) || (!str.toLowerCase().startsWith("http") && !str.toLowerCase().startsWith("https"))) {
            StringBuilder sb = new StringBuilder();
//            sb.append(ContextHelper.mImageUrl);
            sb.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_");
                sb2.append(str2);
                str3 = sb2.toString();
            }
            sb.append(str3);
            sb.append(".png");
            return sb.toString();
        } else if (!str.contains("tfs")) {
            return str;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("_");
                sb4.append(str2);
                str4 = sb4.toString();
            }
            sb3.append(str4);
            sb3.append(".png");
            return sb3.toString();
        }
    }

    public static String getThumbnailFullPathWithFormat(String str, String str2) {
        if (str.toLowerCase().startsWith("http") || str.toLowerCase().startsWith("https")) {
            if (str.contains("tfs") && str.lastIndexOf(".") > 0) {
                str.substring(str.lastIndexOf("."), str.length());
            }
            return str;
        }
        StringBuilder sb = new StringBuilder();
//        sb.append(ContextHelper.mImageUrl);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder getPicUrlByScreenWidth(int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.valueOf(i));
        sb.append("x");
        sb.append(String.valueOf(i / i2));
        return sb;
    }
}

