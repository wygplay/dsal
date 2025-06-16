package com.algorithm.sort;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/19 20:13
 */
public class MergeSort {

    private static int[] aux;

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
        // 第一步排序：遍历左，右区间直至某一区间遍历完毕或整个数据遍历完毕
        while(i < rightBegin && j <= right && k <= right){
            if(arr[i] <= arr[j]) {
                // 可优化为temp[k] = arr[i++]
                temp[k] = arr[i];
                i++;
            }else {
                // 可优化为temp[k] = arr[j++]
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // 边界条件，右区间已遍历完毕，即上述while循环条件 j <= right 提前退出
        while(i < rightBegin) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        // 边界条件，左区间已遍历完毕，即上述while循环条件 j <= right 提前退出
        while(j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        //复制到原数组
        for(int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }

    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        // 左区间
        sort(arr, begin, mid);
        // 右区间
        sort(arr, mid + 1, end);
        // 合并
        mergeSimplified(arr, begin, mid, end);
    }

    public static void merge(int[] arr, int begin, int mid, int end) {
        // 双指针遍历左右区间
        int i = begin;
        int j = mid + 1;
        // 复制待合并区间数据到辅助数组
        for (int k = begin; k <= end; k++) {
            aux[k] = arr[k];
        }

        for (int k = begin; k <= end; k++) {
            if (i < mid + 1 && j <= end) {
                if (aux[i] > aux[j]) {
                    arr[k] = aux[j++];
                } else {
                    arr[k] = aux[i++];
                }
            } else if (i < mid + 1) {
                arr[k] = aux[i++];
            } else if (j <= end) {
                arr[k] = aux[j++];
            }
        }
    }

    /**
     * 简化if嵌套
     *
     * @param arr
     * @param begin
     * @param mid
     * @param end
     */
    public static void mergeSimplified(int[] arr, int begin, int mid, int end) {
        // 双指针遍历左右区间
        int i = begin;
        int j = mid + 1;
        // 复制待合并区间数据到辅助数组
        for (int k = begin; k <= end; k++) {
            aux[k] = arr[k];
        }

        for (int k = begin; k <= end; k++) {
            // 先判断边界条件，右区间先遍历完成的情况
            if (j > end) {
                arr[k] = aux[i++];
            } else if (i > mid) {// 左区间先遍历完成的情况
                arr[k] = aux[j++];
            } else if (aux[i] > aux[j]) {// 左右区间均未遍历完成，比较大小
                arr[k] = aux[j++];
            } else { // 左右区间均未遍历完成，比较大小
                arr[k] = aux[i++];
            }
        }
    }
}
