package com.kymjs.mvpvm.model;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.kymjs.OKHttpUtil;

import java.io.IOException;

import okhttp3.Request;

public class Repository {

    public enum Type {
        CACHE,
        NETWORK,
        DATABASE,
        SHAREDPREFERENCE,
        CACHE_NETWORK,
    }

//    private static final Repository INSTANCE = new Repository();
//
//    private Repository() {
//    }
//
//    public static Repository getInstance() {
//        return INSTANCE;
//    }

    /**
     * 异步请求数据
     */
    public static void get(final Type type, final String key, final ILoader loader) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final String data = syncGet(type, key);
                if (loader != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            loader.onFinished(data);
                        }
                    });
                }
            }
        });
    }

    /**
     * 对外提供异步线程调用同步接口
     */
    @NonNull
    public static String syncGet(final Type type, String key) {

        // 实际项目中可以使用责任链模式做组合，也可以结合适配器模式做扩展

        if (type == Type.CACHE) {
            // 读cache数据
        } else if (type == Type.DATABASE) {
            // 读db数据
        } else if (type == Type.NETWORK) {
            // 读network数据
        } else {
            return "";
        }

        // 仅用作演示代码
        Request request = new Request.Builder().url(key).build();
        try {
            return OKHttpUtil.getOkHttpClient()
                    .newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
