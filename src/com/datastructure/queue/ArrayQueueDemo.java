package com.datastructure.queue;

/**
 * 思路：
 * 队列先入先出，设置两个指针分别指向队列头front，队列尾部rear
 * 当队列增加元素时，rear++，因为新增元素是放再队列尾部
 * 当队列取出元素时，front++，因为取元素时是从头部开始取的
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        arr = new int[maxSize];
    }

    public int popQueue(){
        if(!isEmpty()){
            front++;
            return arr[front];
        }else{
            throw new RuntimeException("队列为空");
        }
    }

    public void addQueue(int value){
        if(!isFull()){
            rear++;
            arr[rear] = value;
        }
    }

    //判断队列是否已经满了
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判读队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //去除头部数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}