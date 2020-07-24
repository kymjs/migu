package com.kymjs.mvpvm.databinding;

import android.os.Bundle;

import com.kymjs.mvpvm.model.IModel;
import com.kymjs.mvpvm.presenter.ActivityPresenter;
import com.kymjs.mvpvm.view.ViewDelegate;


/**
 * 集成数据-视图绑定的Activity基类(Presenter层)
 *
 * @param <V> View层代理类
 */
public abstract class DataBindActivity<V extends ViewDelegate> extends
        ActivityPresenter<V> {
    protected DataBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = getDataBinder();
    }

    public abstract <M extends IModel> DataBinder<V, M> getDataBinder();

    public <D extends IModel> void notifyModelChanged(D data) {
        if (binder != null)
            binder.viewBindModel(viewDelegate, data);
    }

    public <D extends IModel> void notifyViewChanged(D data) {
        if (binder != null)
            binder.modelBindView(viewDelegate, data);
    }
}