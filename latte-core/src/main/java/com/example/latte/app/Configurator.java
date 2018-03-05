package com.example.latte.app;

import android.animation.ObjectAnimator;
import android.os.Handler;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Interceptor;

/**
 * Created by stxr .
 * Date: 17-12-19
 * Time: 上午9:57
 * note: 配置类 单例模式
 * WeakHashMap 可以自动回收内存，避免内存爆满
 * 但是这里是全局配置文件，要一直存在，所以WeakHashMap不太好
 */
public class Configurator {
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    //拦截器
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private static final Handler HANDLER = new Handler();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    /**
     * 静态内部类的单例模式
     * 线程安全的懒汉模式
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    public final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value ==  null) {
            throw new NullPointerException(key.toString() + " is null");
        }
        return (T) LATTE_CONFIGS.get(key);
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            //从1开始，0已经被加入了
            for(int i=1;i<ICONS.size();i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withLoaderDelay(long delay) {
        LATTE_CONFIGS.put(ConfigKeys.LOADER_DELAY, delay);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }
}
