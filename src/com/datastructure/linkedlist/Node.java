package com.datastructure.linkedlist;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/1/3 10:04
 */
public class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name){
        this.name = name;
        this.no = no;
    }
    public Node(int no, String name, String nickName){
        this.name = name;
        this.no = no;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
