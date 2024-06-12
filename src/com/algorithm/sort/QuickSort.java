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
            while (arr[lFind] < pivot) {
                lFind++;
            }
            while (arr[rFind] > pivot) {
                rFind--;
            }
            if (lFind >= rFind) {
                break;
            }
            int temp = arr[lFind];
            arr[lFind] = arr[rFind];
            arr[rFind] = temp;

            //按照上面的赋值方式，若arr[lFind] = arr[rFind] = pivot，会陷入死循环
            if (arr[lFind] == pivot) {
                rFind--;
            }
            if (arr[rFind] == pivot) {
                lFind++;
            }

        }
        //防止递归时，左右两边有重合元素，在只有两个元素的情况下，陷入死循环，栈溢出
        //例如[0, 1] -> [0, 0], [0, 1]，[0, 1]永远循环
        if (lFind == rFind) {
            lFind++;
            rFind--;
        }
        sortWay(arr, left, rFind);
        sortWay(arr, lFind, right);
    }

    /*
    思路：
    1. 分区，找到pivot，中轴值，将数组分为两部分，左边的值都小于pivot，右边的值都大于pivot
    2. 递归，对左右两部分进行分区

    left:数组左边界
    right：数组右边界
    */
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pos = partitionOriginalVersion(arr, left, right);
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }
    }

    public int partitionOriginalVersion(int[] arr, int left, int right) {
        int baseIndex = left;
        int base = arr[left];
        while (left < right) {
            //右指针，从右边开始查找比base小的数
            while (left < right && arr[right] >= base) {
                right--;
            }
            // 左指针，从左边开始查找比base大的数
            while (left < right && arr[left] <= base) {
                left++;
            }
            // 交换比base大的数和比base小的数在数组中的位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        // 循环结束后，left == right，交换base和left位置的数
        // 设置中轴位置
        arr[baseIndex] = arr[left];
        arr[left] = base;
        return left;
    }

    /**
     * 优化版本，减少交换次数，但可能没那么好理解
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }
}
