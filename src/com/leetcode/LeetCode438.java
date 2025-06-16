package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked">找到字符串中所有的异位词</a>
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        // 滑动窗口 遍历
        //  判断窗口内容与 p 是否一致
        int[] pBits = new int[26];
        int[] sBits = new int[26];
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            pBits[p.charAt(i) - 'a']++;
            sBits[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() + 1 - windowSize; i++) {
            if (Arrays.equals(pBits, sBits)) {
                res.add(i);
            }
            sBits[s.charAt(i) - 'a']--;
            if (i < s.length() - windowSize) {
                sBits[s.charAt(i + windowSize) - 'a']++;
            }
        }
        return res;
    }
}
