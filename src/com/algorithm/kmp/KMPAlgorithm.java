package com.algorithm.kmp;

/**
 * 关键：next数组匹配
 * @author wyg
 * @version 1.0
 * @date 2021/6/23 21:29
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str = "ABCABCABCDEFABD";
        String pattern = "ABD";
        int[] next = kmpNext(pattern);
        System.out.println(kmpMatch(str, pattern, next));
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmpMatch(String str, String pattern, int[] next) {
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
            i++;
        }
        return -1;
    }
}
