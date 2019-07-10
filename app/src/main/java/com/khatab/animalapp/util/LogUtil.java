package com.khatab.animalapp.util;

import android.util.Log;

public class LogUtil {
    private static final String TAG = LogUtil.class.getSimpleName();

    public static void verbose(String message) {
        Log.v(TAG, message);

    }

    public static void debug(String message) {
        Log.d(TAG, message);

    }

    public static void error(String message) {
        Log.v(TAG, message);

    }

}
