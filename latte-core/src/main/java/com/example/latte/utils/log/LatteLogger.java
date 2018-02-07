package com.example.latte.utils.log;


import android.os.Build;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Printer;

/**
 * Created by stxr .
 * Date: 18-2-5
 * Time: 下午3:50
 * note: 日志打印类
 *       需要 api 'com.orhanobut:logger:2.1.1'
 */
public class LatteLogger {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARNING = 4;
    private static final int ERROR = 5;
    private static final int NOTIONG = 6;

    private static int LEVEL = VERBOSE;

    private static final String DEFAULT_TAG = "Fastec";
    private static final Printer PRINTER = Logger.t(DEFAULT_TAG);

    public static void init() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static void v(String msg) {
        if (LEVEL <= VERBOSE) {
            PRINTER.v(msg);
        }
    }

    public static void d(String msg) {
        if (LEVEL <= DEBUG) {
            PRINTER.d(msg);
        }
    }

    public static void i(String msg) {
        if (LEVEL <= INFO) {
            PRINTER.i(msg);
        }
    }
    public static void w(String msg) {
        if (LEVEL <= WARNING) {
            PRINTER.w(msg);
        }
    }
    public static void e(String msg) {
        if (LEVEL <= ERROR) {
            PRINTER.e(msg);
        }
    }
    public static void json(String msg) {
        if (LEVEL <= WARNING) {
            PRINTER.json(msg);
        }
    }



}
