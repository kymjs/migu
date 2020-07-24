package com.kymjs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kymjs.databinding.DataBindingActivity;
import com.kymjs.databinding.R;
import com.kymjs.databinding2.DataBindingActivity2;
import com.kymjs.livedata.TestLiveDataActivity;
import com.kymjs.mvpvm.DemoActivity;
import com.kymjs.viewmodel.TestViewModelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button1 = findViewById(R.id.button1);
        button1.setText("Data Binding 演示");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), DataBindingActivity.class));
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setText("RecyclerView 演示");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), DataBindingActivity2.class));
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setText("ViewModel 演示");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TestViewModelActivity.class));
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setText("LiveData 演示");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TestLiveDataActivity.class));
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setText("MVPVM 演示");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), DemoActivity.class));
            }
        });

    }
}