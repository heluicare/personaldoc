package com.google.gooddoctor.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.util.TypedValue;
import java.io.FileDescriptor;
import java.io.InputStream;

public class BitmapFactoryInstrumentation {
    public static Bitmap decodeFile(String str, Options options) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        return decodeFile;
    }

    public static Bitmap decodeFile(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        return decodeFile;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        return decodeResourceStream;
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i, options);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        return decodeResource;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
        return decodeByteArray;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2);
        return decodeByteArray;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
        return decodeStream;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        return decodeStream;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        return decodeFileDescriptor;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        return decodeFileDescriptor;
    }
}