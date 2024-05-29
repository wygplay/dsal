package com.questions;

/**
 * 10亿个数中如何高效地找到最大的一个数以及最大的第K个数
 * <p>
 * 对于top K类问题，通常比较好的方案是分治+hash+小顶堆：
 * 先将数据集按照Hash方法分解成多个小数据集
 * 然后用小顶堆求出每个数据集中最大的K个数
 * 最后在所有top K中求出最终的top K。
 */
public class TopK {
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        int numsLen = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = numsLen - 1; i >= numsLen - k + 1; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, --heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (i != largest) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
