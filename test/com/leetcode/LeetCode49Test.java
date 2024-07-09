package com.leetcode;


import org.junit.Test;

public class LeetCode49Test {

    @Test
    public void groupAnagrams() {
        LeetCode49 lc = new LeetCode49();
        String[] strs = new String[10];
        strs[0] = "eat";
        strs[1] = "tea";
        strs[2] = "tan";
        strs[3] = "ate";
        strs[4] = "nat";
        strs[5] = "bat";
        strs[6] = "a";
        strs[7] = "b";
        strs[8] = "c";
        strs[9] = "d";
        System.out.println(lc.groupAnagrams(strs));
    }
}