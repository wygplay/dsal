package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence">最长连续序列</a>
 * </p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 <br>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int sequenceLength = 1;
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                while(numSet.contains(currentNum + 1)) {
                    currentNum++;
                    sequenceLength++;
                }
            }
            max = Math.max(max, sequenceLength);
        }
        return max;
    }
}
