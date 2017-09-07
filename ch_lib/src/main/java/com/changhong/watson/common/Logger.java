package com.changhong.watson.common;

import android.util.Log;

class Logger {
    public static final String TAG = "ch-log--";
    private static final boolean LOG_ENABLE = true;
    private static final boolean DETAIL_ENABLE = true;

    private Logger() {

    }

    private static String buildMsg(String msg) {
        StringBuilder buffer = new StringBuilder();

        if (DETAIL_ENABLE) {
            final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

            buffer.append("[T:");
            buffer.append(Thread.currentThread().getName());
            buffer.append(" F:");
            buffer.append(stackTraceElement.getFileName());
            buffer.append(" L:");
            buffer.append(stackTraceElement.getLineNumber());
            buffer.append(" M:");
            buffer.append(stackTraceElement.getMethodName());
            buffer.append("()]--");
        }
        buffer.append(msg);
        return buffer.toString();

    }

    public static void v(String msg) {
        if (LOG_ENABLE) {
            Log.v(TAG, buildMsg(msg));
        }
    }

    public static void v(String TAG, String msg) {
        if (LOG_ENABLE) {
            Log.v(TAG, buildMsg(msg));
        }
    }

    public static void d(String msg) {
        if (LOG_ENABLE) {
            Log.d(TAG, buildMsg(msg));
        }
    }

    public static void d(String TAG, String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.DEBUG)) {
        if (LOG_ENABLE) {
            Log.d(TAG, buildMsg(msg));
        }
    }

    public static void i(String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.INFO)) {
        if (LOG_ENABLE) {
            Log.i(TAG, buildMsg(msg));
        }
    }

    public static void i(String TAG, String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.INFO)) {
        if (LOG_ENABLE) {
            Log.i(TAG, buildMsg(msg));
        }
    }

    public static void w(String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.WARN)) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg));
        }
    }

    public static void w(String TAG, String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.WARN)) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg));
        }
    }

    public static void w(String msg, Exception e) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.WARN)) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg), e);
        }
    }

    public static void w(String TAG, String msg, Exception e) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.WARN)) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg), e);
        }
    }

    public static void e(String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.ERROR)) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg));
        }
    }

    public static void e(String TAG, String msg) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.ERROR)) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg));
        }
    }

    public static void e(String msg, Exception e) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.ERROR)) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg), e);
        }
    }

    public static void e(String TAG, String msg, Exception e) {
        // if (LOG_ENABLE && Log.isLoggable(TAG, Log.ERROR)) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg), e);
        }
    }
}
