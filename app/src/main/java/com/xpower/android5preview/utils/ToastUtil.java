package com.xpower.android5preview.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class ToastUtil {

    public static void showShort(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
