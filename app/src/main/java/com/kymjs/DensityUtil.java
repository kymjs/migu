package com.kymjs;

import android.content.res.Resources;
import android.util.TypedValue;

public class DensityUtil {

    public static int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
                Resources.getSystem().getDisplayMetrics());
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
