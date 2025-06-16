package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode560Test {

    @Test
    public void subArraySum() {
        int[] nums = {1, 2, 3};
        int k = 3;
        LeetCode560 lc = new LeetCode560();
        assertEquals(2, lc.subArraySum(nums, k));
    }

}