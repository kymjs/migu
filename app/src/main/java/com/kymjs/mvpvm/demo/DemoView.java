package com.kymjs.mvpvm.demo;

import android.widget.TextView;

import com.kymjs.databinding.R;
import com.kymjs.mvpvm.view.ViewDelegate;

public class DemoView extends ViewDelegate {
    public TextView textView;

    @Override
    public int getRootLayoutId() {
        return R.layout.delegate_simple;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        textView = get(R.id.text);
        textView.setText("在视图代理层创建布局");
    }

    public void setText(String text) {
        TextView textView = get(R.id.text);
        textView.setText(text);
    }
}
