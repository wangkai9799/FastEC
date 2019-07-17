package com.dankai.latte.util.timer;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.util.timer
 *  文件名:    BaseTimerTask
 *  创建者:    WK
 *  时间：     2019/7/14 21:41
 *  描述：     TODO
 */

import java.util.TimerTask;

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
