package com.namagz.testcase1;

import android.app.Application;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by user on 2/25/16.
 */
public class AppControler extends Application {
    public static  final String TAG = AppControler.class.getSimpleName();
    RequestQueue mRequestQueQue;
    private  static AppControler mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppControler getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueQue == null) {
            mRequestQueQue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueQue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueQue != null) {
            mRequestQueQue.cancelAll(tag);
        }
    }
}
