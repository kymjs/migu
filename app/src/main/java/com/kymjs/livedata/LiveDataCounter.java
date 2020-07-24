package com.kymjs.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataCounter extends ViewModel {

    private MutableLiveData<Counter> countData = new MutableLiveData<>();


    public MutableLiveData<Counter> getCountData() {
        return countData;
    }

    public void setCountData(MutableLiveData<Counter> countData) {
        this.countData = countData;
    }
}
