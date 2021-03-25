package com.datastructure.stack;

/**
 * 单向链表
 * first.next == null  or top == first
 * top指针始终指向栈顶元素
 * push推到栈顶
 * pop取出栈顶元素
 *
 */
public class LinkedStack {
    private Node first;
    private Node top;
    private int size;

    public LinkedStack() {
        first = new Node();
        top = first;
    }
    public void push(String e) {
        top.next = new Node(e);
        top = top.next;
    }
    private class Node {
        public String val;
        public Node next;

        public Node() {}

        public Node(String val) {
            this.val = val;
        }
    }
}
