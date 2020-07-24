package com.kymjs.databinding2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kymjs.databinding.R;
import com.kymjs.databinding.databinding.ItemRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.DBViewHolder> {

    private List<Product> productList;

    public DBAdapter(List<Product> productList) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        this.productList = productList;
    }

    @NonNull
    @Override
    public DBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerviewBinding binding = DataBindingUtil.inflate(((Activity) parent.getContext()).getLayoutInflater(),
                R.layout.item_recyclerview, null, false);
        return new DBViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DBViewHolder holder, final int position) {
        holder.binding.setEntity(productList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.get(position).setName("已修改");
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class DBViewHolder extends RecyclerView.ViewHolder {
        public ItemRecyclerviewBinding binding;

        public DBViewHolder(ItemRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    //用@BindingAdapter标注，有点类似自定义属性，后面是属性名，方法体类似得到属性值后去做的事情。
    //第一个参数：是当前的控件类型，其实也可以写成View，但是要加载还是要判断是否是imageView
    //第二个参数：是网络加载的url。
    @BindingAdapter("imageWithGlide")
    public static void loadImage(ImageView imageView, String url) {
//        if (show) {
//            imageView.setVisibility(View.VISIBLE);
//        } else {
//            imageView.setVisibility(View.GONE);
//        }
        if (imageView instanceof ImageView) {
            Glide.with(imageView).load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .centerCrop()
                    .into((ImageView) imageView);
        } else {
//            Glide.with(imageView).load(url)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
//                    .centerCrop()
//                    .into(new Simpleta<>);
        }
    }
}

