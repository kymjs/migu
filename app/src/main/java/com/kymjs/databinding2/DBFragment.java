package com.kymjs.databinding2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kymjs.databinding.R;
import com.kymjs.databinding.databinding.FragmentRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

public class DBFragment extends Fragment {
    private FragmentRecyclerviewBinding recyclerBinding;
    private List<Product> products = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        recyclerBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_recyclerview, null, false);
        return recyclerBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setName("第" + i + "个商品");
            product.setDailyPrice(i * 100);
            if (i % 3 == 0) {
                product.setPrice(i);
            }
            product.setUrl("https://kymjs.com/qiniu/image/logo3.png");
            products.add(product);
        }
        recyclerBinding.recyclerview.setAdapter(new DBAdapter(products));
        recyclerBinding.setOnChangeData(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products.get(0).setName("一本书");
            }
        });
        recyclerBinding.setProduct(products.get(1));
    }
}
