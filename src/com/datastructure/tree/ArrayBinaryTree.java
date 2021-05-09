package com.datastructure.tree;

/**
 * 将数据存储至数组中，并采用二叉树前、中、后序遍历数组
 * 仅考虑完全二叉树，根据完全二叉树左右子结点与父结点的对应关系，进行遍历
 * @author wyg
 * @version 1.0
 * @date 2021/5/9 10:26
 */
public class ArrayBinaryTree {
    private int[] arr;
    public ArrayBinaryTree() {
        this.arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i +1;
        }
    }

    public void preOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        preOrder(0);
    }

    public void infixOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        infixOrder(0);
    }

    public void postOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        postOrder(0);
    }

    public void preOrder(int i) {
        System.out.println(arr[i]);
        if (getLeft(i) != -1) {
            preOrder(getLeft(i));
        }

        if (getRight(i) != -1) {
            preOrder(getRight(i));
        }
    }

    public void infixOrder(int i) {
        if (getLeft(i) != -1) {
            infixOrder(getLeft(i));
        }

        System.out.println(arr[i]);

        if (getRight(i) != -1) {
            infixOrder(getRight(i));
        }
    }

    public void postOrder(int i) {
        if (getLeft(i) != -1) {
            postOrder(getLeft(i));
        }

        if (getRight(i) != -1) {
            postOrder(getRight(i));
        }

        System.out.println(arr[i]);
    }

    private int getLeft(int i) {
        return 2 * i + 1 < arr.length ? 2 * i + 1 : -1;
    }

    private int getRight(int i) {
        return 2 * i + 2 < arr.length ? 2 * i + 2 : -1;
    }
}
