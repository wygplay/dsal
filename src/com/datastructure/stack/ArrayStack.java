package com.datastructure.stack;

/**
 * 数组初始尺寸
 * top指针
 * push推到栈顶
 * pop取出栈顶元素
 * top返回栈顶元素
 *
 */
public class ArrayStack {
    private int maxSize;
    private String[] arr;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new String[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(String e) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        arr[top] = e;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        String tmp = arr[top];
        top--;
        return tmp;
    }

    public String getTop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        return arr[top];
    }

    public int getSize() {
        return top + 1;
    }
}
