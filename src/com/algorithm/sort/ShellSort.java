package com.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序
 * 对插入排序的一种优化，优化移动次数，将较小值以最低成本移至数组前端
 * @author wyg
 * @version 1.0
 * @date 2021/4/17 20:59
 */
public class ShellSort {
    public static void sort(int[] arr) {
        //待排序表，按照数量可分的组数，例如10个元素的表，可按照层次依次分为5个组，2各组，1各组；并分别根据5各组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分成gap组, 每次循环分别对每个组的1个元素进行插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertValue;
            }
        }
    }

}
