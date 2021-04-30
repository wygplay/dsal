package com.algorithm.search;

/**
 * 斐波那契查找
 * 利用斐波那契数列来寻找分组查找的临界值，f(k) = f(k - 1) + f(k - 2)-->f(k) - 1 = f(k - 1) - 1 + f(k - 2) - 1 + 1
 * @author wyg
 * @version 1.0
 * @date 2021/4/29 22:13
 */
public class FibSearch {
    private FibSearch(){}
    public static int fib(int k) {
        int preTwice = 1;
        int pre = 1;
        if (k < 2) {
            return 1;
        }
        int fk = 0;
        int i = 2;
        while (i < k + 1) {
            fk = pre + preTwice;
            preTwice = pre;
            pre = fk;
            i++;
        }
        return fk;
    }

    public static int search(int[] arr, int key) {
        int k = 0;
        while (fib(k) < arr.length) {
            k++;
        }
        return fibSearch(arr, 0, arr.length - 1, key, k);
    }

    private static int fibSearch(int[] arr, int start, int end, int key, int k) {
        if (start > end) {
            return -1;
        }
        int fibMid = start + fib(k - 1) - 1;
        if (arr[fibMid] == key) {
            return fibMid;
        } else if (arr[fibMid] > key) {
            k--;
            return fibSearch(arr, start, fibMid - 1, key, k);
        } else {
            //fib(k - 1) + fib(k - 2),向右查找长度为fib(k - 2)，可能超出数组长度
            //两种方式：1、用数组最高位填充数组长度为f(k) 2、重新计算k值
            k = 0;
            while (fib(k) < end - fibMid) {
                k++;
            }
            return fibSearch(arr, fibMid + 1, end, key,  k);
        }
    }
}
