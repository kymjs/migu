package com.kymjs.mvpvm.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.kymjs.databinding.R;
import com.kymjs.databinding.databinding.ItemPagerSliderBinding;
import com.kymjs.mvpvm.demo.data.Product;

public class PagerFragment extends Fragment {
    private ItemPagerSliderBinding binding;
    private Product product;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (binding == null) {
            binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.item_pager_slider, null, false);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setProduct(product);
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
