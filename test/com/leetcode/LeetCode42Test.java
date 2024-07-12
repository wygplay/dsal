package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode42Test {

    @Test
    public void trapTest() {
        LeetCode42 lc = new LeetCode42();

        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected1 = 6;
        assertEquals(expected1, lc.trap(height1));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        int expected2 = 9;
        assertEquals(expected2, lc.trap(height2));

        int[] height3 = {1, 0, 1};
        int expected3 = 1;
        assertEquals(expected3, lc.trap(height3));

        int[] height4 = {0, 0, 0};
        int expected4 = 0;
        assertEquals(expected4, lc.trap(height4));

        int[] height5 = {2, 0, 2};
        int expected5 = 2;
        assertEquals(expected5, lc.trap(height5));

        int[] height6 = {4, 2, 3};
        int expected6 = 1;
        assertEquals(expected6, lc.trap(height6));
    }

}