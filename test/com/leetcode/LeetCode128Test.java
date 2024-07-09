package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode128Test {

    @Test
    public void longestConsecutive() {
        LeetCode128 lc = new LeetCode128();
        int[] numsA = {1, 2, 3, 3, 2, 2, 2, 2};
        int[] numsB = {2, 2, 4, 3, 2, 1};
        int[] numsC = {4, 3, 5, 5, 5, 1, 2};
        assertEquals(3, lc.longestConsecutive(numsA));
        assertEquals(4, lc.longestConsecutive(numsB));
        assertEquals(5, lc.longestConsecutive(numsC));
    }
}