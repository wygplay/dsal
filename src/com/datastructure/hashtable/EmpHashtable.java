package com.datastructure.hashtable;

import java.util.Arrays;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/30 20:02
 */
public class EmpHashtable {
    private int size = 7;
    private EmpLinkedList[] arr;

    public EmpHashtable() {
        this.arr = new EmpLinkedList[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new EmpLinkedList();
        }
    }

    private int hash(int key) {
        return key % this.arr.length;
    }

    public void add(Emp emp) {
        int remainder = hash(emp.id);
        EmpLinkedList list = arr[remainder];
        list.add(emp);
    }

    public void remove(int key) {
        int remainder = hash(key);
        EmpLinkedList list = arr[remainder];
        list.remove(key);
    }

    public void edit(Emp emp) {
        int remainder = hash(emp.id);
        EmpLinkedList list = arr[remainder];
        list.edit(emp);
    }

    public Emp find(int key) {
        int remainder = hash(key);
        EmpLinkedList list = arr[remainder];
        return list.find(key);

    }
    public void print() {
        for (EmpLinkedList list : arr) {
            System.out.println("--------------------------------------------------");
            list.print();
        }
    }
}
