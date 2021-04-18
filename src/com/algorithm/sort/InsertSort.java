package com.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 * 将无序的列表依次插入有序列表中，从小到大的顺序
 * 相比选择排序，最优情况为O(n)，最差情况接近
 * @author wyg
 * @version 1.0
 * @date 2021/4/17 16:30
 */
public class InsertSort {
    public static void execSort(int[] arr) {
        //遍历无序数组
        for (int i = 1; i < arr.length; i++) {
            //遍历有序数组，将待排序数组前面的
            for (int j = i - 1 ; j >= 0; j--) {
                if(arr[j + 1] < arr[j]) {
                    //因为是数组，数组插入需要考虑将后续值后移
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //加上会变慢,一定程度上能说明，插入排序较慢的原因
            //int val = arr[insertIndex + 1];
            //arr[insertIndex + 1] = val;
            arr[insertIndex + 1] = insertValue;
        }
        System.out.println(sdf.format(new Date()));
    }
}