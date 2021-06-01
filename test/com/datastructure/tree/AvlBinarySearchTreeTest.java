package com.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/24 22:52
 */
public class AvlBinarySearchTreeTest {
    int[] arr = {4, 3, 6, 5, 8, 9};
    int[] arrLeft = {10,11,7,6,8,9};
    @Before
    public void init() {

    }

    @Test
    public void add() {
        AvlBinarySearchTree avlBSTree = new AvlBinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            avlBSTree.add(arr[i]);
        }
    }

    @Test
    public void add2() {
        AvlBinarySearchTree avlBSTree = new AvlBinarySearchTree();
        for (int i = 0; i < arrLeft.length; i++) {
            avlBSTree.add(arrLeft[i]);
        }
        System.out.println(avlBSTree.getRootValue());
    }
}