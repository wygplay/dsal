package com.algorithm.sort;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/12 22:31
 */
public class HeapSort {
    public static void sort(int[] arr, int length) {
        if(length == 0) {
            return;
        }
        int index = length/2 - 1;
        while(index >= 0) {
            int temp = arr[index];
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left <= length - 1 && right <= length -1) {
                if(arr[left] < arr[right] && arr[right] > arr[index]) {
                    arr[index] = arr[right];
                    arr[right] = temp;
                } else if (arr[right] < arr[left] && arr[left] > arr[index]) {
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
            } else if (left <= length - 1){
                if(arr[left] > arr[index]) {
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
            }
            index--;
        }
        //以上代码并未将数组初始化为堆结构（所有父结点均不小于子结点），仅仅是将最大值，推至堆顶，
        int temp = arr[0];
        arr[0] = arr[length - 1];
        arr[length - 1] = temp;
        sort(arr, length - 1);
    }
}
