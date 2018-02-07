package com.example.latte.ec.sign;

/**
 * Created by stxr .
 * Date: 18-2-6
 * Time: 下午9:40
 * note:
 */
public interface ISignerListener {
    //登陆成功后的回调
    void onSignInSuccess();

    //注册成功的回调
    void onSignUpSuccess();
}
