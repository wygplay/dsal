package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeetCode15Test {

    @Test
    public void testThreeSum() {
        LeetCode15 lc = new LeetCode15();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        assertEquals(expected1, lc.threeSum(nums1));

        int[] nums2 = {};
        List<List<Integer>> expected2 = new ArrayList<>();
        assertEquals(expected2, lc.threeSum(nums2));

        int[] nums3 = {0};
        List<List<Integer>> expected3 = new ArrayList<>();
        assertEquals(expected3, lc.threeSum(nums3));

        int[] nums4 = {0, 0, 0};
        List<List<Integer>> expected4 = Collections.singletonList(
                Arrays.asList(0, 0, 0)
        );
        assertEquals(expected4, lc.threeSum(nums4));

        int[] nums5 = {-2, 0, 1, 1, 2};
        List<List<Integer>> expected5 = Arrays.asList(
                Arrays.asList(-2, 0, 2),
                Arrays.asList(-2, 1, 1)
        );
        assertEquals(expected5, lc.threeSum(nums5));

        int[] nums6 = {-4, -2, -2, 0, 1, 2, 2, 3, 3, 4, 4};
        List<List<Integer>> expected6 = Arrays.asList(
                Arrays.asList(-4, 0, 4),
                Arrays.asList(-4, 1, 3),
                Arrays.asList(-4, 2, 2),
                Arrays.asList(-2, -2, 4),
                Arrays.asList(-2, 0, 2)
        );
        assertEquals(expected6, lc.threeSum(nums6));
    }
}
