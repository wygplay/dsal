package com.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/9 10:55
 */
public class ArrayBinaryTreeTest {

    private ArrayBinaryTree arrayBinaryTree;

    @Before
    public void init() {
        arrayBinaryTree = new ArrayBinaryTree();
    }

    @Test
    public void preOrder() {
        arrayBinaryTree.preOrder();
    }

    @Test
    public void infixOrder() {
        arrayBinaryTree.infixOrder();
    }

    @Test
    public void postOrder() {
        arrayBinaryTree.postOrder();
    }
}