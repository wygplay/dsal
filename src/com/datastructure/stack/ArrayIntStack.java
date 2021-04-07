package com.datastructure.stack;

import java.util.Arrays;

/**
 * 数组初始尺寸
 * top指针
 * push推到栈顶
 * pop取出栈顶元素
 * top返回栈顶元素
 *
 * @author WYG
 */
public class ArrayIntStack {
    private int maxSize;
    private int[] arr;
    private int top = -1;

    public ArrayIntStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int e) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        arr[top] = e;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        int tmp = arr[top];
        top--;
        return tmp;
    }

    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        return arr[top];
    }
    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public int getSize() {
        return top + 1;
    }
}
