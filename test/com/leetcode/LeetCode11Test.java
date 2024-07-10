package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode11Test {

    @Test
    public void maxArea() {
        LeetCode11 lc = new LeetCode11();
        int[] heightA = {10, 10, 1, 1, 1, 1};
        int[] heightB = {1, 1, 1, 1, 10, 10};
        int[] heightC = {10, 5, 1, 1, 1, 10};
        int[] heightD = {5, 5, 1, 1, 1, 2};
        int[] heightE = {3, 1, 10, 10, 1, 1};
        assertEquals(10, lc.maxArea(heightA));
        assertEquals(10, lc.maxArea(heightB));
        assertEquals(50, lc.maxArea(heightC));
        assertEquals(10, lc.maxArea(heightD));
        assertEquals(10, lc.maxArea(heightE));
    }
}