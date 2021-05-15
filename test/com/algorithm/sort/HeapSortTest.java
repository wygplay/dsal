package com.algorithm.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/12 23:12
 */
public class HeapSortTest {
    public static final int maxSize = 10;
    int[] arr = new int[maxSize];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Before
    public void init() {
        Random rand = new Random();
        for (int i = 0; i < maxSize; i++) {
            arr[i] = rand.nextInt(maxSize *  10);
        }
        System.out.println(sdf.format(new Date()));
    }
    @Test
    public void heapSort() {
        HeapSort.sort(arr);
    }

    @Test
    public void sort() {
        //初始化堆
        for (int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeapSort(arr, i, arr.length);
        }
        //交换与重构
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeapSort(arr, 0, j);
        }
    }

    public void adjustHeapSort(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * i + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    @After
    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}