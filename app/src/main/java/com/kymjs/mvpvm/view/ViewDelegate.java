package com.kymjs.mvpvm.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.kymjs.databinding.R;

/**
 * 视图层代理的基类
 */
public abstract class ViewDelegate implements IView {

    protected View rootView;

    public abstract int getRootLayoutId();

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int rootLayoutId = getRootLayoutId();
        rootView = inflater.inflate(rootLayoutId, container, false);
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void initWidget() {
    }

    public <T extends Activity> T getPresenter() {
        return (T) rootView.getContext();
    }

    protected final SparseArray<View> mViews = new SparseArray<>();

    public <T extends View> T get(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }

}
