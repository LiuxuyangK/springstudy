package com.study.lxy.util;

/**
 * Created by Harry on 17/8/6.
 */
public class StringUtils {
    public static boolean isEmpty(String param){
        if(param == null || param.equals("")){
            return true;
        }

        return false;
    }
}
