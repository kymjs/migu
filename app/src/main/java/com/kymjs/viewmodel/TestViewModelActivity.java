package com.kymjs.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import com.kymjs.databinding.R;
import com.kymjs.databinding.databinding.ActivityViewpagerBinding;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class TestViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Counter counter = new ViewModelProvider(this).get(Counter.class);

        ActivityViewpagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_viewpager);
        binding.viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return new ViewModelFragment();
            }

            @Override
            public int getCount() {
                return 10;
            }
        });
    }
}
