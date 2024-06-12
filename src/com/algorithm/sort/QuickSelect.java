package com.algorithm.sort;


/**
 * 从快速排序中衍生出来的快速选择算法
 * 计算第 k 小的值
 * 思路：
 * 利用快速排序的思路，第一次分区计算找到pivot
 * 比较pivot与k的大小，若pivot == k，则返回arr[pivot]
 * 若pivot > k，则在左边分区继续查找，重复上述步骤
 * 若pivot < k，则在右边分区继续查找，重复上述步骤
 * 注意：不需要像快速排序一样，对左右两边都进行递归，只需要对一边进行递归即可
 */
public class QuickSelect {

    public int select(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return arr[left];
        }
        int pivot = partition(arr, left, right);
        if (pivot == k) {
            return arr[pivot];
        } else if (pivot > k) {
            return select(arr, k, left, pivot - 1);
        } else {
            return select(arr, k, pivot + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int baseIndex = left;
        int base = arr[left];
        while (left < right) {
            // 右指针查找比base低的值
            while (left < right && arr[right] >= base) {
                right--;
            }
            // 左指针查找比base高的值
            while (left < right && arr[left] <= base) {
                left++;
            }
            // 交换左右指针查找到的值
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 交换pivot与base处的值
        arr[baseIndex] = arr[left];
        arr[left] = base;
        return left;
    }
}
