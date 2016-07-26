package com.xpower.android5preview.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class CommonUtil {

    public static List<String> array2List (String[] array) {
        List<String> temp = new ArrayList<String>();
        for (String s:array) {
            temp.add(s);
        }
        return temp;
    }
}
