package com.example.latte.utils.timer;

import java.util.TimerTask;

/**
 * Created by stxr .
 * Date: 18-2-1
 * Time: 下午3:40
 * note:
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }


    @Override
    public void run() {
        //接口要判断是否为空，否则会有很多麻烦
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
