package com.leetcode;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked">盛最多水的容器</a>
 */
public class LeetCode11 {
    /**
     * 利用双指针方法计算
     * key: 高 * 宽，两个高中最低的决定实际计算的高度，宽动态变化
     * 最重要的是，因为遍历的关系，宽度肯定是不断变化的，那么遍历的方式实际上就决定了高的选择策略
     *
     * @param height 数组
     * @return 整数
     */
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int currenArea = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, currenArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
