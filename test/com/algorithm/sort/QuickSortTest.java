package com.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] arr = {0, 5, 2, 1, 6, 3};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{0, 1, 2, 3, 5, 6}, arr);
    }
}