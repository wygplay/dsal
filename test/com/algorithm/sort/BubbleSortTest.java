package com.algorithm.sort;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/15 23:04
 */
public class BubbleSortTest {
    public static final int maxSize = 80000;
    int[] arr = new int[maxSize];
    @Before
    public void init() {
        Random rand = new Random();
        for (int i = 0; i < maxSize; i++) {
            arr[i] = rand.nextInt(maxSize * 10);
        }
        //System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testBubble() {
        //1-15s、2-16s\3-18s
        BubbleSort.sort(arr);
    }
    @Test
    public void testSelectSort() {
        //1-5s\2-6s\3-6s
        //SelectSort.sort(arr);
        //1-13s\2-13s\
        SelectSort.sortEveryTime(arr);
    }
    @After
    public void print() {
        //System.out.println(Arrays.toString(arr));
    }
}