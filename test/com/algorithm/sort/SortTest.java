package com.algorithm.sort;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/15 23:04
 */
public class SortTest {
    public static final int maxSize = 8000000;
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
    public void testBubble() {
        //1-15s、2-16s\3-18s
        BubbleSort.sort(arr);
    }
    @Test
    public void testSelectSort() {
        //1-5s\2-6s\3-6s
        SelectSort.sort(arr);
        //1-13s\2-13s\
        //SelectSort.sortEveryTime(arr);
    }
    @Test
    public void testInsertSort() {
        //80000数据结果 1-3s\2-1s\3-1s
        //80000数据最差结果
        InsertSort.execSort(arr);
        //InsertSort.sort(arr);
    }

    @Test
    public void testShellSort() {
        ShellSort.sort(arr);
    }

    @Test
    public void testQuickSort() {
        QuickSort.sort(arr);
    }

    @Test
    public void testMergeSort() {
        int[] temp = new int[maxSize];
        MergeSort.sort(arr, 0, arr.length -1, temp);
    }

    @Test
    public void testRadixSort() {
        RadixSort.sort(arr);
    }

    @Test
    public void heapSort() {
        HeapSort.sort(arr);
    }

    @After
    public void print() {
        System.out.println(sdf.format(new Date()));
        assertTrue(isSorted());
    }

    public boolean isSorted() {
        for (int i = 0; i  < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}