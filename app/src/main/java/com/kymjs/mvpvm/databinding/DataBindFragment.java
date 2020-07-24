package com.kymjs.mvpvm.databinding;

import android.os.Bundle;
import android.view.View;

import com.kymjs.mvpvm.model.IModel;
import com.kymjs.mvpvm.presenter.FragmentPresenter;
import com.kymjs.mvpvm.view.ViewDelegate;


/**
 * 集成数据-视图绑定的Fragment基类(Presenter层)
 *
 * @param <V> View层代理类
 */
public abstract class DataBindFragment<V extends ViewDelegate> extends
        FragmentPresenter<V> {

    protected DataBinder binder;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
