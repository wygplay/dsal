package com.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class HuffmanTreeTest {
    public static final int maxSize = 10;
    int[] arr = new int[maxSize];
    @Before
    public void init() {
        Random rand = new Random();
        for (int i = 0; i < maxSize; i++) {
            arr[i] = rand.nextInt(maxSize * 2);
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void createHuffmanTree() {
        HuffmanTreeNode root = HuffmanTree.createHuffmanTree(arr);
        root.preOrder();
    }
}