package com.kymjs.mvpvm.demo;

import android.os.Bundle;
import android.view.View;

import com.kymjs.databinding.R;
import com.kymjs.mvpvm.databinding.DataBindActivity;
import com.kymjs.mvpvm.databinding.DataBinder;
import com.kymjs.mvpvm.demo.data.Product;

public class DemoActivity2 extends DataBindActivity<DemoView> implements View.OnClickListener {

    private Product product = new Product();

    @Override
    public DataBinder<DemoView, Product> getDataBinder() {
        return new DataBinder<DemoView, Product>() {
            @Override
            public void viewBindModel(DemoView viewDelegate, Product data) {
                viewDelegate.textView.setText(data.getProductName());
            }

            @Override
            public void modelBindView(DemoView viewDelegate, Product data) {
                data.setProductName(viewDelegate.textView.getText().toString());
            }
        };
    }

    @Override
    protected Class<DemoView> getDelegateClass() {
        return DemoView.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product.setProductName("商品名");
        product.setDailyPrice(100);
        product.setPrice(80);
        product.setImgUrl("https://kymjs.com/qiniu/image/logo3.png");
        //可以同时对多个控件设置同一个点击事件,后面id参数可以传多个
        viewDelegate.setOnClickListener(this, R.id.button1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                product.setProductName("你点击了button");
                // 当数据发生了改变，通知viewmodel修改UI
                notifyModelChanged(product);
                // 当UI发生了改变，通知viewmodel修改数据
//                notifyViewChanged(product);
                break;
        }
    }
}
