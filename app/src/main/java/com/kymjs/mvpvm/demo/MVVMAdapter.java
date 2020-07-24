package com.kymjs.mvpvm.demo;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.kymjs.databinding.R;
import com.kymjs.databinding.databinding.ItemPresonAreaBinding;
import com.kymjs.databinding.databinding.ItemSliderBinding;
import com.kymjs.databinding.databinding.ItemTimeLimitBinding;
import com.kymjs.databinding.databinding.ItemTodaySelectionBinding;
import com.kymjs.mvpvm.demo.data.MVVMData;

import java.util.ArrayList;
import java.util.List;

public class MVVMAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TYPE_SLIDER = "slider";
    private static final String TYPE_PRESONAREA = "presonArea";
    private static final String TYPE_TIMELIMIT = "timeLimit";
    private static final String TYPE_TODAYSELECTION = "todaySelection";

    private List<MVVMData.ModuleData> dataList;

    public MVVMAdapter(List<MVVMData.ModuleData> dataList) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.dataList = dataList;
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        MVVMData.ModuleData data = dataList.get(position);
        switch (data.getType()) {
            case TYPE_SLIDER:
                return 0;
            case TYPE_PRESONAREA:
                return 1;
            case TYPE_TIMELIMIT:
                return 2;
            case TYPE_TODAYSELECTION:
                return 3;
            default:
                return 0;
        }
    }

    void refresh(List<MVVMData.ModuleData> dataList) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.dataList.addAll(dataList);
        notifyItemRangeInserted(this.dataList.size() - dataList.size(), this.dataList.size());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Activity activity = (Activity) parent.getContext();
        switch (viewType) {
            case 0:
                return new SliderViewHolder((ItemSliderBinding) DataBindingUtil.inflate(activity.getLayoutInflater(),
                        R.layout.item_slider, null, false));
            case 1:
                return new PresonAreaViewHolder((ItemPresonAreaBinding) DataBindingUtil.inflate(activity.getLayoutInflater(),
                        R.layout.item_preson_area, null, false));
            case 2:
                return new TimeLimitViewHolder((ItemTimeLimitBinding) DataBindingUtil.inflate(activity.getLayoutInflater(),
                        R.layout.item_time_limit, null, false));
            case 3:
                return new TodaySelectionViewHolder((ItemTodaySelectionBinding) DataBindingUtil.inflate(activity.getLayoutInflater(),
                        R.layout.item_today_selection, null, false));
            default:
                return new SliderViewHolder((ItemSliderBinding) DataBindingUtil.inflate(activity.getLayoutInflater(),
                        R.layout.item_slider, null, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof SliderViewHolder) {
//            ViewGroup.LayoutParams layoutParams = ((SliderViewHolder) holder).binding.viewpager.getLayoutParams();
//            if (layoutParams == null) {
//                layoutParams = new ViewGroup.LayoutParams(DensityUtil.getScreenWidth(), DensityUtil.getScreenHeight() / 2);
//            } else {
//                layoutParams.width = DensityUtil.getScreenWidth();
//                layoutParams.height = DensityUtil.getScreenHeight();
//            }
//            ((SliderViewHolder) holder).binding.viewpager.setLayoutParams(layoutParams);

            ((SliderViewHolder) holder).binding.viewpager.setAdapter(new FragmentPagerAdapter(((FragmentActivity) holder.itemView.getContext()).getSupportFragmentManager()) {
                @Override
                public int getCount() {
                    return dataList.get(position).getEntityList().size();
                }

                @NonNull
                @Override
                public Fragment getItem(int p) {
                    PagerFragment pagerFragment = new PagerFragment();
                    pagerFragment.setProduct(dataList.get(position).getEntityList().get(p));
                    return pagerFragment;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        public ItemSliderBinding binding;

        public SliderViewHolder(ItemSliderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class PresonAreaViewHolder extends RecyclerView.ViewHolder {
        public ItemPresonAreaBinding binding;

        public PresonAreaViewHolder(ItemPresonAreaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class TimeLimitViewHolder extends RecyclerView.ViewHolder {
        public ItemTimeLimitBinding binding;

        public TimeLimitViewHolder(ItemTimeLimitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class TodaySelectionViewHolder extends RecyclerView.ViewHolder {
        public ItemTodaySelectionBinding binding;

        public TodaySelectionViewHolder(ItemTodaySelectionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
