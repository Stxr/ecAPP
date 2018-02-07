package com.example.latte.ec.sign;

import com.alibaba.fastjson.JSONObject;
import com.example.latte.app.AccountManager;
import com.example.latte.ec.database.DataBaseManager;
import com.example.latte.ec.database.UserProfile;

/**
 * Created by stxr .
 * Date: 18-2-6
 * Time: 下午4:35
 * note:
 */
public class SignHandler {
    public static void onSignIn(String response, ISignerListener listener) {
        JSONObject object = JSONObject.parseObject(response).getJSONObject("data");

        final String name = object.getString("name");
        final long userId = object.getLong("userId");
        final String avatar = object.getString("avatar");
        final String gender = object.getString("gender");
        final String address = object.getString("address");

        final UserProfile userProfile = new UserProfile(userId, name, avatar, gender, address);

        DataBaseManager.getInstance().getDao().insert(userProfile);

        AccountManager.setSignState(true);
        listener.onSignInSuccess();
    }

    public static void onSignUp(String response, ISignerListener listener) {
        final JSONObject profileJson = JSONObject.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DataBaseManager.getInstance().getDao().insert(profile);

        //注册成功了
        AccountManager.setSignState(true);

        //回调
        listener.onSignUpSuccess();
    }
}
