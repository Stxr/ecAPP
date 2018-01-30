package com.example.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by stxr .
 * Date: 17-12-19
 * Time: 上午9:54
 * note:
 */
public final class Latte {
    public static Configurator init(Context context) {
        //传入context
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
