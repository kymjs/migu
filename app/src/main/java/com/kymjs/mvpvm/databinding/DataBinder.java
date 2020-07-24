package com.kymjs.mvpvm.databinding;

import com.kymjs.mvpvm.model.IModel;
import com.kymjs.mvpvm.view.ViewDelegate;

/**
 * ViewModel实现
 */
public interface DataBinder<V extends ViewDelegate, M extends IModel> {

    /**
     * 将数据与View绑定，这样当数据改变的时候，框架就知道这个数据是和哪个View绑定在一起的，就可以自动改变ui
     * 当数据改变的时候，会回调本方法。
     *
     * @param viewDelegate 视图层代理
     * @param data         数据模型对象
     */
    void viewBindModel(V viewDelegate, M data);

    /**
     * 将数据与View绑定，这样当数据改变的时候，框架就知道这个数据是和哪个View绑定在一起的，就可以自动改变ui
     * 当ui改变的时候，会回调本方法。
     *
     * @param viewDelegate 视图层代理
     * @param data         数据模型对象
     */
    void modelBindView(V viewDelegate, M data);
}
