package com.datastructure.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/22 12:23
 */
public class BinarySortTreeTest {
    BinarySortTree binarySortTree;
    int maxSize = 10;
    int[] arr;
    @Before
    public void init() {
        binarySortTree = new BinarySortTree();
        arr = new int[maxSize];
        Random rand = new Random();
        for (int i = 0; i < maxSize; i++) {
            arr[i] = rand.nextInt(maxSize *  10);
        }

    }

    @Test
    public void add() {
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(arr[i]);
        }

    }

    @Test
    public void remove() {
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            binarySortTree.remove(arr[i]);
            binarySortTree.print();
            System.out.println("----------");
        }

    }

    @After
    public void print() {
        binarySortTree.print();
        System.out.println(Arrays.toString(arr));
    }
}