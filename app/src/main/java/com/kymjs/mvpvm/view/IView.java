package com.kymjs.mvpvm.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;

/**
 * 视图层代理的接口协议
 */
public interface IView {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();

    Toolbar getToolbar();

    View getRootView();

    void initWidget();
}
