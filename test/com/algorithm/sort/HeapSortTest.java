package com.algorithm.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        HeapSort.sort(arr, maxSize);
    }

    @After
    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}