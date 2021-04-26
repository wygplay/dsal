package com.algorithm.sort;

/**
 * 基数排序，桶排序的扩展
 * 按照数字的个、十、百......等位的数字一次进行排序，前一次排序的结果作为后一次排序的基准
 *
 * @author WYG
 */
public class RadixSort {
    private RadixSort(){}
    public static void sort(int[] arr) {
        //桶
        int[][] buckets = new int[10][arr.length];
        //record numbers of inserted in bucket
        int[] bucketIndex = new int[10];

        radixSort(arr, buckets, bucketIndex, 1);

    }

    private static void radixSort(int[] arr, int[][] buckets, int[] bucketIndex, int radix) {
        for (int value : arr) {
            int radixNum = value % (radix * 10) / radix;
            buckets[radixNum][bucketIndex[radixNum]] = value;
            //指向数组中值的下一位的下标值
            bucketIndex[radixNum]++;
        }
        //退出条件
        if (bucketIndex[0] == arr.length) {
            return;
        }
        //赋值
        int arrIndex = 0;
        for (int j = 0; j < buckets.length; j++) {
            int bucketNum = bucketIndex[j];
            for (int k = 0; k < bucketNum; k++) {
                arr[arrIndex] = buckets[j][k];
                bucketIndex[j]--;
                arrIndex++;
            }
        }
        radixSort(arr, buckets, bucketIndex, radix * 10);
    }
}
