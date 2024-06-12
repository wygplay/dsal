package com.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSelectTest {

    @Test
    public void select() {
        QuickSelect select = new QuickSelect();
        int[] arr = new int[]{8, 7, 1, 2, 5, 3};
        // 找数组中第 k 小，转换成数组下标为 k - 1
        int k = 3;
        assertEquals(5, select.select(arr, k, 0, arr.length - 1));
    }

}