package com.wanou.toolsutilslibrary.utils;

import java.text.DecimalFormat;

/**
 * @author wodx521
 * @date on 2018/8/15
 */
public class NumFormatUtils {
    private static DecimalFormat decimalFormat = new DecimalFormat();

    /**
     * 格式化数字为String
     *
     * @param pattern 格式化后的文本样式
     * @param num     需要格式化的数字
     * @return 格式化后返回的文本
     */
    public static String formatNumber(String pattern, Object num) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(num);
    }

    /**
     * 格式化double类型数字为String
     *
     * @param pattern 格式化后的文本样式
     * @param num     需要格式化的数字
     * @return 格式化后返回的文本
     */
    public static String formatNumber(String pattern, double num) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(num);
    }

    /**
     * 格式化long类型数字为String
     *
     * @param pattern 格式化后的文本样式
     * @param num     需要格式化的数字
     * @return 格式化后返回的文本
     */
    public static String formatNumber(String pattern, long num) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(num);
    }
}
