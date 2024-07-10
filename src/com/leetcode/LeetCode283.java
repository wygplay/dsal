package com.leetcode;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes">移动零</a>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        // 双指针法
        int left = 0;
        int right = 0;
        int length = nums.length;
        while(right < length) {
            if (nums[right] != 0 && left != right) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
