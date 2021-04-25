package com.algorithm.sort;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/19 20:13
 */
public class MergeSort {
    public static void sort(int[] arr, int left, int right, int[] temp) {
        while (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);
        //合并,使用插入排序会怎样
        mergeSec(arr, left, mid,mid + 1, right, temp);
    }

    /**
     * 此方法有个问题，当一边已经全部插入时，该边的最后一个值会持续参与比较
     * @param arr
     * @param left
     * @param leftEnd
     * @param rightBegin
     * @param right
     * @param temp
     */
    public static void mergeFirst(int[] arr, int left, int leftEnd, int rightBegin, int right, int[] temp) {
        int i = left;
        int j = rightBegin;
        int k = left;
        while(k <= right){
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //复制
        for(int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }

    /**
     * 对第一种方式进行优化，当一边插入完之后，将另一边后面所有值全部插入
     * @param arr
     * @param left
     * @param leftEnd
     * @param rightBegin
     * @param right
     * @param temp
     */
    public static void mergeSec(int[] arr, int left, int leftEnd, int rightBegin, int right, int[] temp) {
        int i = left;
        int j = rightBegin;
        int k = left;
        while(i < rightBegin && j <= right && k <= right){
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //插入剩余值
        while(i < rightBegin) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        //复制
        for(int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }
}
