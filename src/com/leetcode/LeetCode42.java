package com.leetcode;


/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked">接雨水</a>
 */
public class LeetCode42 {
    public int trap(int[] height) {
        // 确定一个k为边
        // 确定另一个边i，向右寻找height[i] > height[k] 或 (k, length-1)区间中的最大值
        // 求两边之间的容积
        // 递增k，循环上步操作
        // 边界条件： 1、k == 0 跳过
        int area = 0;
        for (int k = 0; k < height.length - 1; ) {
            // find the other edge i
            if (height[k] == 0) {
                k++;
                continue;
            }
            int edge = k + 1;
            int maxIndex = k + 1;
            for (int i = k + 1; i < height.length; i++) {
                if (height[i] >= height[maxIndex]) {
                    maxIndex = i;
                    edge = maxIndex;
                }
                if (height[i] > height[k]) {
                    edge = i;
                    break;
                }
            }
            int baseHeight = Math.min(height[edge], height[k]);
            for (int j = k + 1; j < edge; j++) {
                area += baseHeight - height[j];
            }
            k = edge;
        }
        return area;
    }
}
