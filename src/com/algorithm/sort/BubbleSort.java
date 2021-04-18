package com.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序，从小到大。
 * 双重循环，left > right 交换，不产生交换的情形下，退出循环
 * 最好O(n)，最坏O(n^2)，平均O(n^2)
 * @author wyg
 * @version 1.0
 * @date 2021/4/15 22:42
 */
public class BubbleSort {
    private BubbleSort(){}
    public static void sort(int[] arr) {
        //每层遍历目的选出一个最大值
        for (int i = 0; i < arr.length; i++) {
            boolean continueFlag = true;
            //两两比较比较出较大值，依次排在后面
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    continueFlag = false;
                }
            }
            if (continueFlag) {
                break;
            }
        }
    }
}
