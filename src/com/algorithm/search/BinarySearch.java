package com.algorithm.search;

/**
 * 使用递归实现二分查找
 * 退出条件
 * @author wyg
 * @version 1.0
 * @date 2021/4/28 21:18
 */
public class BinarySearch {
    public static boolean search(int[] arr, int left, int right, int num) {
        if (left > right) {
            return false;
        }
        int middle = (left + right) / 2;
        if (arr[middle] == num) {
            return true;
        } else if (arr[middle] < num) {
            return search(arr, middle + 1, right, num);
        } else {
            return search(arr, left, middle - 1, num);
        }
    }
}
