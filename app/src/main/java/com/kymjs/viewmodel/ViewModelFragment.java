package com.kymjs.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kymjs.databinding.R;

public class ViewModelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return View.inflate(getActivity(), R.layout.fragment_viewmodel, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Counter counter = new ViewModelProvider(requireActivity()).get(Counter.class);

        final TextView textView = view.findViewById(R.id.content);
        textView.setText(String.valueOf(counter.getCount()));

        Button button = view.findViewById(R.id.button);
        button.setText("读取当前值");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setCount(counter.getCount() + 1);
                textView.setText(String.valueOf(counter.getCount()));
            }
        });
    }
}
