package com.algorithm.dynamicprograming;

/**
 * 公共子字符串
 * 三个问题：
 * 1、坐标轴是什么
 *  两个子字符串的按序字母
 * 2、子问题是什么
 *
 * 3、单元格值表示的意义
 * 截止到当前字母公共子字符串长度
 * @author wyg
 * @version 1.0
 * @date 2021/6/13 17:00
 */
public class SubStringQuestion {
    public static int maxSubString(String a, String b) {
        int[][] overlapping = new int[a.length()][b.length()];
        byte[] byteA = a.getBytes();
        byte[] byteB = b.getBytes();
        int num = 0;
        for (int i = 0; i < byteA.length; i++) {
            for (int j = 0; j < byteB.length; j++) {
                if (byteA[i] == byteB[j]) {
                    if (i > 0 && j > 0) {
                        overlapping[i][j] = overlapping[i - 1][j - 1] + 1;
                        num = overlapping[i][j] > num ? overlapping[i][j] : num;
                    } else {
                        overlapping[i][j] = 1;
                    }
                 }
            }
        }
        return num;
    }
}
