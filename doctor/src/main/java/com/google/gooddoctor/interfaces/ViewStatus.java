package com.google.gooddoctor.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ViewStatus {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

}