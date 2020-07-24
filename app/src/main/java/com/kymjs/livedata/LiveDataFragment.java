package com.kymjs.livedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kymjs.databinding.R;

public class LiveDataFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return View.inflate(getActivity(), R.layout.fragment_viewmodel, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LiveDataCounter liveDataCounter = new ViewModelProvider(requireActivity()).get(LiveDataCounter.class);

        final TextView textView = view.findViewById(R.id.content);
        Counter counter = liveDataCounter.getCountData().getValue();
        if (counter == null) {
            counter = new Counter();
        }
        textView.setText(String.valueOf(counter.getCount()));

        Button button = view.findViewById(R.id.button);
        button.setText("读取当前值");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter counter = liveDataCounter.getCountData().getValue();
                if (counter == null) {
                    counter = new Counter();
                }
                counter.plus();
                // 发送了livedata 消息，告诉livedata当前数据发生了变化
                liveDataCounter.getCountData().postValue(counter);
            }
        });

        Observer<Counter> observer = new Observer<Counter>() {
            @Override
            public void onChanged(Counter integer) {
                textView.setText(String.valueOf(integer.getCount()));
            }
        };
        liveDataCounter.getCountData().observe(requireActivity(), observer);
    }


    void requestData(){
        // 请求到网络数据
//        textView.setText("xx");
//        liveDataCounter.getCountData().postValue("xx");
    }

}
