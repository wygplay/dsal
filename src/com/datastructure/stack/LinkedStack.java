package com.datastructure.stack;

/**
 * 单向链表, 跟队列不同
 * top.next == null
 * top.next指针始终指向栈顶元素
 * push推到栈顶
 * pop取出栈顶元素
 *
 */
public class LinkedStack {
    private Node top;
    private int size = 0;

    public LinkedStack() {
        top = new Node();
    }

    public void push(String e) {
        Node node = new Node(e);
        node.next = top.next;
        top.next = node;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        Node tmp = top.next;
        top = top.next;
        size--;
        return tmp.val;
    }

    public String getTop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        return top.next.val;
    }

    public void show() {
        Node tmp = top.next;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top.next == null;
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
