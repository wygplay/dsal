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
    public static void insertSort(int[] arr) {
        //遍历无序数组
        for (int i = 1; i < arr.length; i++) {
            //遍历有序数组，将待排序数组前面的
            for (int j = 0 ; j < i; j++) {
                //注意此方法没有将比较与插入同时做，因此增加额外的时间复杂度,成为O(n^3)
                if(arr[i] < arr[j]) {
                    //因为是数组，数组插入需要考虑将后续值后移
                    insert(j, i, arr);
                    break;
                }
            }
        }
    }

    public static void insert(int destIndex, int srcIndex, int[] arr) {
        int srcValue = arr[srcIndex];
        for(int i = destIndex; i < srcIndex + 1; i++) {
            int tmp = arr[i];
            arr[i] = srcValue;
            srcValue = tmp;
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