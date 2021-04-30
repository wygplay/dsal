package com.algorithm.search;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/28 21:31
 */
public class SearchTest {
    private final int MAX_SIZE = 100;
    private int[] arr = new int[MAX_SIZE];
    @Before
    public void init() {
        IntStream.range(0, MAX_SIZE).forEach(i -> arr[i] = i);
    }

    @Test
    public void testBinarySearch() {
        assertTrue(BinarySearch.search(arr, 0, arr.length - 1, new Random().nextInt(MAX_SIZE - 1)));
        assertFalse(BinarySearch.search(arr, 0, arr.length - 1, MAX_SIZE));
    }

    @Test
    public void testFibSearch() {
        int key = new Random().nextInt(MAX_SIZE - 1);
        key = 99;
        Assert.assertEquals(FibSearch.search(arr,  key), key);
    }
}