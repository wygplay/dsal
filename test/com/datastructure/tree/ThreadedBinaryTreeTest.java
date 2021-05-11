package com.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/10 8:41
 */
public class ThreadedBinaryTreeTest {
    public ThreadedBinaryTree binaryTree;
    ThreadedBinaryTreeNode nodeA =  new ThreadedBinaryTreeNode(1, "刘备");
    ThreadedBinaryTreeNode nodeB =  new ThreadedBinaryTreeNode(2, "关羽");
    ThreadedBinaryTreeNode nodeC =  new ThreadedBinaryTreeNode(3, "张飞");
    ThreadedBinaryTreeNode nodeD =  new ThreadedBinaryTreeNode(4, "赵云");
    ThreadedBinaryTreeNode nodeE =  new ThreadedBinaryTreeNode(5, "马超");
    @Before
    public void init() {
        binaryTree = new ThreadedBinaryTree(nodeA);
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeC.left = nodeD;
        nodeC.right = nodeE;
    }
    @Test
    public void infixOrderThreading() {
        binaryTree.root.infixOrder();
        binaryTree.infixOrderThreading(binaryTree.root);
        binaryTree.threadedInfixOrder();
    }

    @Test
    public void threadedInfixOrder2() {
        binaryTree.root.infixOrder();
        binaryTree.infixOrderThreading2(binaryTree.root);
        binaryTree.threadedInfixOrder2();
    }
}