package com.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeetCode438Test {

    @Test
    public void findAnagrams() {
        String s = "abab";
        String p = "ab";
        LeetCode438 lc = new LeetCode438();
        List<Integer> expect = Arrays.asList(0, 1, 2);
        assertEquals(expect, lc.findAnagrams(s, p));
    }

    @Test
    public void findAnagramsB() {
        String s = "cbaebabacd";
        String p = "abc";
        LeetCode438 lc = new LeetCode438();
        List<Integer> expect = Arrays.asList(0, 6);
        assertEquals(expect, lc.findAnagrams(s, p));
    }
}