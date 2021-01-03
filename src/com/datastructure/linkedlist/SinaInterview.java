package com.datastructure.linkedlist;

import java.util.Stack;

/**
 * 求单向链表倒数第K个节点
 *
 * @author wyg
 * @version 1.0
 * @date 2021/1/3 9:58
 */
public class SinaInterview {
    public static void main(String[] args) {
        Node nodeA = new Node(1, "a");
        Node nodeB = new Node(2, "b");
        Node nodeC = new Node(7, "c");
        Node nodeD = new Node(8, "d");
        Node nodeE = new Node(3, "e");
        Node nodeF = new Node(10, "f");
        SingleLinkedList skl = new SingleLinkedList();
        SingleLinkedList sklA = new SingleLinkedList();
        SingleLinkedList sklB = new SingleLinkedList();
        skl.add(nodeA);
        skl.add(nodeB);
        skl.add(nodeC);
        skl.add(nodeD);
        sklB.add(nodeE);
        sklB.add(nodeF);
        /*skl.list();
        Stack<Node> stack = skl.pushStack();
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        reverse(skl);*/
        mergeInOrder(sklA, sklB);
        sklA.list();
        sklB.list();
    }

    /**
     * 合并两个有序单链表
     * 假设：均为从小到大有序排列的链表
     * 实现思路：
     * 从一个链表中取出节点
     * 顺序插入链表方法编写
     * 注意事项：
     * 相同的key同不同的key同样处理方法
     * 两个链表是有序的, 不必每次从头开始遍历，但插入的
     */
    public static void mergeInOrder(SingleLinkedList a, SingleLinkedList b) {
        Node headA = a.getHead();
        Node headB = b.getHead();
        Node insertNode = headA;
        if(insertNode.next == null){
            headA.next = headB.next;
            return;
        }
        Node pop = b.pop();
        while(pop != null){
            while(insertNode.next.no < pop.no){
                insertNode = insertNode.next;
                //注意判断空放在后面，因为insertNode.next.no < pop.n条件在前
                if(insertNode.next == null){
                    insertNode.next = pop;
                    return;
                }
            }
            Node temp = insertNode.next ;
            insertNode.next = pop;
            pop.next = temp;
            insertNode = pop;
            pop = b.pop();
        }
    }

    /**
     * 反转链表，实际上是链表元素的取值、删除、插入
     * 注意链表在操作的过程中，next指针的变化同时作用于两个链表,因此需要将节点从链表取出并删除
     * 空链表或只有一个节点的链表无需反转
     *
     * @param skl
     * @return
     */
    public static void reverse(SingleLinkedList skl) {
        SingleLinkedList reverseLinkedList = new SingleLinkedList();
        Node tail = skl.popTail();
        while (tail != null) {
            reverseLinkedList.add(tail);
            tail = skl.popTail();
        }
        skl.getHead().next = reverseLinkedList.getHead().next;
    }
}

class SingleLinkedList {

    private Node head = new Node(0, "");

    public Node getHead() {
        return head;
    }

    public int getTotal() {
        int num = 0;
        Node temp = head.next;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        return num;
    }

    /**
     * 大于链表总结点数total时
     * k小于链表节点数total时
     * 倒数第k个即第total - k + 1个节点
     *
     * @param k
     * @return
     */
    public Node getTail(int k) {
        if (k > getTotal()) {
            throw new RuntimeException("取值超过链表最大长度");
        }
        int num = 1;
        Node temp = head.next;
        while (num != getTotal() - k + 1) {
            num++;
            temp = temp.next;
        }
        return temp;
    }

    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        Node temp = head.next;
        while (temp != null) {
            System.out.printf("no: %d, name: %s\n", temp.no, temp.name);
            temp = temp.next;
        }
    }

    public Node popTail() {
        Node preTemp = head;
        Node temp = head.next;
        if (temp == null) {
            return null;
        }
        while (temp.next != null) {
            preTemp = temp;
            temp = temp.next;
        }
        preTemp.next = null;
        return temp;
    }

    /**
     * 以栈的方式从头到尾打印
     *
     * @return
     */
    public Stack<Node> pushStack() {
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        return stack;
    }

    /**
     * 取出第一个元素，为空时返回null
     */
    public Node pop(){
        Node pop = head.next;
        if(pop!=null){
            head.next = pop.next;
        }
        return pop;
    }
}