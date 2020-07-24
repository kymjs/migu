package com.kymjs.mvpvm.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.kymjs.databinding.R;
import com.kymjs.mvpvm.databinding.DataBindActivity;
import com.kymjs.mvpvm.databinding.DataBinder;
import com.kymjs.mvpvm.demo.data.MVVMData;
import com.kymjs.mvpvm.demo.data.Product;
import com.kymjs.mvpvm.model.ILoader;
import com.kymjs.mvpvm.model.Repository;
import com.kymjs.mvpvm.presenter.ActivityPresenter;

public class MVVMActivity extends AppCompatActivity {

    private Gson gson = new Gson();
    private MVVMData data = new MVVMData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MvvmView viewDelegate = new MvvmView();
        setContentView(viewDelegate.getRootView());
        viewDelegate.initWidget();
        final MVVMAdapter mvvmAdapter = new MVVMAdapter(data.getModuleDataList());

        Repository.get(Repository.Type.NETWORK, "http://oss.kymjs.com/zhangtao/1.json", new ILoader() {
            @Override
            public void onFinished(@NonNull String json) {
                data = gson.fromJson(json, MVVMData.class);
                viewDelegate.recyclerView.setAdapter(mvvmAdapter);
            }
        });

        // 模拟用户下拉刷新，改变数据源
        Repository.get(Repository.Type.CACHE, "http://oss.kymjs.com/zhangtao/1.json", new ILoader() {
            @Override
            public void onFinished(@NonNull String json) {
                data = gson.fromJson(json, MVVMData.class);
                // 通知适配器重绘
                mvvmAdapter.refresh(data.getModuleDataList());
            }
        });
    }
}
