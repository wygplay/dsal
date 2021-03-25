package com.datastructure.selinkedlist;

import com.datastructure.linkedlist.Node;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node nodeA = new Node(1, "a", "a");
        Node nodeB = new Node(2, "b", "b");
        Node nodeC = new Node(3, "c", "c");
        Node nodeD = new Node(4, "d", "d");
        SingleLinkedList skl = new SingleLinkedList();
        skl.add(nodeA);
        skl.add(nodeB);
        skl.add(nodeD);
        skl.edit(new Node(5, "z", "z"));
        skl.edit(new Node(4, "x", "x"));
        skl.list();

    }
}

class SingleLinkedList{
    private Node head = new Node(0, "", "");
    public void add(Node node){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //根据no值进行顺序插入，找到待插入的位置，如果重复进行提示
    public void addByOrder(Node node){
        Node temp = head;
        boolean flag = false;
         while(true){
             if(temp.next == null){
                 break;
             }else if(temp.next.no > node.no){
                 break;
             } else if(temp.next.no == node.no){
                 flag = true;
                 break;
             }
             temp = temp.next;
         }
         if(flag){
             System.out.println("不可重复添加");
             return;
         }else{
             node.next = temp.next;
             temp.next = node;
         }
    }

    //遍历链表找到no，修改name，name；可能有找不到的情况
    public void edit(Node node){
        Node temp = head.next;
        boolean flag = false;
        while (temp != null){
            if ( temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if ( flag){
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else{
            System.out.println("节点不存在");
        }
    }

    public void remove(Node node){

    }

    public void list(){
        if(head.next == null){
            System.out.println("list is null");
            return;
        }
        Node temp = head;
        while(true){
            if(temp.next != null){
                temp = temp.next;
                System.out.printf("no: %d, name: %s, nickName: %s\n", temp.no, temp.name, temp.nickName);
            } else{
                break;
            }
        }
    }
}

