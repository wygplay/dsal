package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked">三数之和</a>
 */
public class LeetCode15 {
    /**
     * 双指针法，时间复杂度O(n^2)
     *
     * @param nums 数组
     * @return List
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 针对排序后的数组使用双指针遍历
        for (int k = 0; k < nums.length; k++) {
            // 有序数组，若nums[k] > 0，那么k右侧区间值均大于0，则 nums[k] + nums[i] + nums[j] 恒大于0
            if (nums[k] > 0) {
                break;
            }
            // k相邻位置处值相同时跳过
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定k，使用双指针遍历k右侧有序数组
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int s = nums[k] + nums[j] + nums[i];
                if (s > 0) {
                    j--;
                } else if (s < 0) {
                    i++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 剔重
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return result;
    }
}
