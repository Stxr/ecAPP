package com.example.latte.delegates.bottom;

/**
 * Created by stxr .
 * Date: 18-2-7
 * Time: 下午3:17
 * note: 导航栏底部的图标和文字
 */
public final class BottomTabBean {
    //声明未final并在构造方法中初始化可以避免多线程中出现的问题
    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        ICON = icon;
        TITLE = title;
    }


    public CharSequence getICON() {
        return ICON;
    }

    public CharSequence getTITLE() {
        return TITLE;
    }
}
