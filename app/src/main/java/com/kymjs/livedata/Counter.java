package com.kymjs.livedata;

import androidx.lifecycle.ViewModel;

public class Counter extends ViewModel {
    private int count;

    public void plus() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
