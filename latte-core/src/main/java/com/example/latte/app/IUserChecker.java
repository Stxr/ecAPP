package com.example.latte.app;

/**
 * Created by stxr .
 * Date: 18-2-6
 * Time: 下午9:29
 * note:
 */
public interface IUserChecker {
    /**
     * 登陆状态回调
     */
    void onSignIn();

    /**
     * 未登陆状态回调
     */
    void onNotSignIn();
}
