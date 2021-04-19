package com.algorithm.sort;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/17 14:58
 */
public class QuickSort {

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sortWay(arr, left, right);
    }

    public static void sortWay(int[] arr, int left, int right) {
        //找出pivot，中轴值，计算公式，(begin + end)/2
        if (left >= right) {
            return;
        }
        int pivot = arr[(right + left) / 2];
        int lFind = left;
        int rFind = right;
        while (lFind < rFind) {
            while(arr[lFind] < pivot) {
                lFind++;
            }
            while(arr[rFind] > pivot) {
                rFind--;
            }
            if (lFind >= rFind) {
                break;
            }
            int temp = arr[lFind];
            arr[lFind] = arr[rFind];
            arr[rFind] = temp;

            //按照上面的赋值方式，若arr[lFind] = arr[rFind] = pivot，会陷入死循环
            if(arr[lFind] == pivot) {
                rFind--;
            }
            if(arr[rFind] == pivot) {
                lFind++;
            }

        }
        //防止递归时，左右两边有重合元素，在只有两个元素的情况下，陷入死循环，栈溢出
        //例如[0, 1] -> [0, 0], [0, 1]，[0, 1]永远循环
        if(lFind == rFind) {
            lFind++;
            rFind--;
        }
        sortWay(arr, left, rFind);
        sortWay(arr, lFind, right);
    }
}
