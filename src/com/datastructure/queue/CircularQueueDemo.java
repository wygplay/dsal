package com.datastructure.queue;

import java.util.Arrays;

public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.addQueue(1);
        cq.addQueue(2);
        cq.addQueue(3);
        cq.addQueue(4);
        System.out.println(cq.toString());
        System.out.println(cq.getQueue());
        cq.addQueue(5);
        System.out.println(cq.toString());
        System.out.println(cq.getQueue());
        System.out.println(cq.getQueue());
        System.out.println(cq.getQueue());
        System.out.println(cq.toString());
        cq.addQueue(6);
        cq.addQueue(7);
        cq.addQueue(8);
        System.out.print(cq.toString());
        cq.addQueue(8);

    }
}

/**
 * 环形队列
 */
class CircularQueue{
    private int front = 0;
    private int rear = 0;
    private int maxSize;
    private int size;
    private int[] arr;

    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public void addQueue(int val){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[rear] = val;
        rear = (rear + 1 ) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int val = arr[front];
        front = (front + 1 ) % maxSize;
        return val;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1 - front) % maxSize == 0;
    }

    public int size(){
        return (rear  + maxSize - front) % maxSize;
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
        }
    }

    public String toString(){
        return "########################\nfront: " + front + "\nrear: " + rear + "\nseize: " + size + "\narr: " + Arrays.toString(arr);
    }
}
