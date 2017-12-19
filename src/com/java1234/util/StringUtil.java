package com.java1234.util;

/**
 * ×Ö·û´®¹¤¾ßÀà
 *
 * @author Administrator
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if ("".equals(str) || str == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        if (!"".equals(str) && str != null) {
            return true;
        } else {
            return false;
        }
    }


}
