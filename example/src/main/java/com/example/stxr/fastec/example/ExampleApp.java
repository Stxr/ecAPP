package com.example.stxr.fastec.example;

import android.app.Application;
import android.util.Log;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DataBaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.example.latte.utils.log.LatteLogger;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.Logger;

/**
 * Created by stxr .
 * Date: 17-12-19
 * Time: 上午10:27
 * note:
 */
public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .configure();


        DataBaseManager.getInstance().init(this);
        LatteLogger.init();
    }
}
