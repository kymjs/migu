package com.kymjs.mvpvm.model;

import androidx.annotation.NonNull;

public interface ILoader {
    void onFinished(@NonNull String entry);
}
