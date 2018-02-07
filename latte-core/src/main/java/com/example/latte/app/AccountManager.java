package com.example.latte.app;

import com.example.latte.utils.storage.LattePreference;

/**
 * Created by stxr .
 * Date: 18-2-6
 * Time: 下午9:30
 * note:
 */
public class AccountManager {
    private enum SignTag {
        SIGN_TAG
    }

    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }

}
