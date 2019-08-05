package com.dankai.latte.ec.pay;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.pay
 *  文件名:    FastPay
 *  创建者:    WK
 *  时间：     2019/8/5 15:06
 *  描述：     TODO
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.JSON;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;

public class FastPay implements View.OnClickListener {

    //设置支付监听回调
    private IAlPayResultListener mIAlPayResultListener = null;
    private Activity mActivity = null;

    private AlertDialog mDialog = null;
    private int mOrderID = -1;

    private FastPay(LatteDelegate delegate) {
        this.mActivity = delegate.getActivity();
        this.mDialog = new AlertDialog.Builder(delegate.getContext()).create();
    }

    public static FastPay create(LatteDelegate delegate) {
        return new FastPay(delegate);
    }

    public void beginPayDialog() {
        mDialog.show();
        final Window window = mDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.dialog_pay_panel);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置属性
            final WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(params);

            window.findViewById(R.id.btn_dialog_pay_alpay).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_pay_wechat).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_pay_cancel).setOnClickListener(this);
        }
    }

    public FastPay setPayResultListener(IAlPayResultListener listener) {
        this.mIAlPayResultListener = listener;
        return this;
    }

    public FastPay setOrderId(int orderId) {
        this.mOrderID = orderId;
        return this;
    }

    public final void alpay(int orderId) {
        final String signUrl = "http://10.0.2.2/Test";
        //获取签名字符串
        RestClient.builder()
                .url(signUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String paySign = JSON.parseObject(response).getString("result");
                        //必须是异步的调用客户端支付接口
                        final PayAsyncTask payAsyncTask = new PayAsyncTask(mActivity, mIAlPayResultListener);
                        payAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paySign);
                    }
                })
                .build()
                .post();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_dialog_pay_alpay) {
//            alpay(mOrderID);
            mDialog.cancel();
        } else if (id == R.id.btn_dialog_pay_wechat) {
            mDialog.cancel();
        } else if (id == R.id.btn_dialog_pay_cancel) {
            mDialog.cancel();
        }
    }
}
