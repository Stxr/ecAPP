package com.example.latte.app;

/**
 * Created by stxr .
 * Date: 17-12-19
 * Time: 上午9:59
 * note: 枚举类在整个应用程序里是唯一的单例，可以用来进行惰性单利的初始化
 */
public enum ConfigType {
    API_HOST,   //网络请求域名
    APPLICATION_CONTEXT,  //全局上下文
    CONFIG_READY,  //初始化
    ICON
}
