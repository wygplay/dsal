package com.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 * 与冒泡排序相比较，时间复杂度，均为O(n^2)，但是实际使用数组代码实现排序时，选择排序交换可以在比较中仅交换索引值，在最后一步再交换数组值，即数组值交换动作仅有n - 1次，而冒泡则与循环次数接近，因此实际时间消耗冒泡大于选择
 * 需要明白的是时间消耗的点不在与算法本身，而是在于循环内操作的过程
 * 主要是降低了交换次数
 * @author wyg
 * @version 1.0
 * @date 2021/4/15 23:30
 */
public class SelectSort {
    public static void sort(int[] arr) {
        //每层遍历目的，剩余范围内选出一个最小值,放在i位置上
        for (int i = 0; i < arr.length; i++) {
            //两两比较，比较出较小值，依次放在i位置上
            int tmp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[tmp]) {
                    //记录索引位置，最后替换一次
                    tmp = j;
                }
            }
            if (tmp != i) {
                int val = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = val;
            }

        }
    }

    /**
     * 每次比较遇到较小值都进行交换
     * @param arr
     */
    public static void sortEveryTime(int[] arr) {
        //每层遍历目的，剩余范围内选出一个最小值,放在i位置上
        for (int i = 0; i < arr.length; i++) {
            //两两比较，比较出较小值，依次放在i位置上
            for (int j = i + 1; j < arr.length; j++) {
                //每次将比较出的较小值放在i位置上
                if(arr[j] < arr[i]) {
                    int val = arr[i];
                    arr[i] = arr[j];
                    arr[j] = val;
                }
            }

        }
    }
}
