package com.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] expected = {0, 1, 2, 3, 5, 6};
        int[] arr = {0, 5, 2, 1, 6, 3};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}