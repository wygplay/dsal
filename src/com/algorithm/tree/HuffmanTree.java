package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static HuffmanTreeNode createHuffmanTree(int[] arr) {
        List<HuffmanTreeNode> nodes = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            nodes.add(new HuffmanTreeNode(arr[i]));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanTreeNode left = nodes.get(0);
            HuffmanTreeNode right = nodes.get(1);
            HuffmanTreeNode parent = new HuffmanTreeNode(left.value + right.value, left, right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
    public int value;
    public HuffmanTreeNode left;
    public HuffmanTreeNode right;
    public HuffmanTreeNode(int value) {
        this.value = value;
    }
    public HuffmanTreeNode(int value, HuffmanTreeNode left, HuffmanTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HuffmanTreeNode that = (HuffmanTreeNode) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "value=" + value +
                '}';
    }
}