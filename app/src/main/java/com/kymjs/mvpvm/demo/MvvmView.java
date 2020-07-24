package com.kymjs.mvpvm.demo;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kymjs.databinding.R;
import com.kymjs.mvpvm.view.ViewDelegate;

public class MvvmView extends ViewDelegate {

    public RecyclerView recyclerView;

    @Override
    public int getRootLayoutId() {
        return R.layout.mvvmview;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        recyclerView = get(R.id.content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getRootView().getContext()));
    }
}
