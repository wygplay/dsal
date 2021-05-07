package com.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author wyg
 * @version 1.0
 * @date 2021/5/5 19:46
 */
public class BinaryTreeTest {

    public BinaryTree binaryTree;
    @Before
    public void init() {
        BinaryTreeNode nodeA =  new BinaryTreeNode(1, "刘备");
        BinaryTreeNode nodeB =  new BinaryTreeNode(2, "关羽");
        BinaryTreeNode nodeC =  new BinaryTreeNode(3, "张飞");
        BinaryTreeNode nodeD =  new BinaryTreeNode(4, "赵云");
        BinaryTreeNode nodeE =  new BinaryTreeNode(5, "马超");
        binaryTree = new BinaryTree(nodeA);
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeC.left = nodeD;
        nodeC.right = nodeE;
    }

    @Test
    public void preOrder() {
        binaryTree.preOrder();
    }

    @Test
    public void infixOrder() {
        binaryTree.root.infixOrder();
    }

    @Test
    public void postOrder() {
        binaryTree.root.postOrder();
    }

    @Test
    public void preOrderSearch() {
        BinaryTreeNode node = binaryTree.root.preOrderSearch(6);
        System.out.println(node);
    }

    @Test
    public void infixOrderSearch() {
        BinaryTreeNode node = binaryTree.root.infixOrderSearch(6);
        System.out.println(node);
    }

    @Test
    public void postOrderSearch() {
        BinaryTreeNode node = binaryTree.root.postOrderSearch(6);
        System.out.println(node);
    }

    @Test
    public void remove() {
        binaryTree.remove(1);
        binaryTree.preOrder();
    }

    @Test
    public void removeByRule() {
        binaryTree.removeByRule(3);
        binaryTree.preOrder();
    }
}