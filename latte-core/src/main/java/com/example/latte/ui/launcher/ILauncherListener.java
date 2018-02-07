package com.example.latte.ui.launcher;

/**
 * Created by stxr .
 * Date: 18-2-6
 * Time: 下午10:45
 * note:
 */
public interface ILauncherListener {
    void onLauncherFinish(OnLauncherFinishTag tag);

    enum  OnLauncherFinishTag {
        SIGNED,
        NOT_SIGNED
    }
}
