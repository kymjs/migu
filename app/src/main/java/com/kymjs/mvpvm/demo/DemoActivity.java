package com.kymjs.mvpvm.demo;

import android.os.Bundle;
import android.view.View;

import com.kymjs.databinding.R;
import com.kymjs.mvpvm.presenter.ActivityPresenter;

public class DemoActivity extends ActivityPresenter<DemoView> implements View.OnClickListener {
    @Override
    protected Class<DemoView> getDelegateClass() {
        return DemoView.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //可以同时对多个控件设置同一个点击事件,后面id参数可以传多个
        viewDelegate.setOnClickListener(this, R.id.button1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                viewDelegate.setText("你点击了button");
                break;
        }
    }
}