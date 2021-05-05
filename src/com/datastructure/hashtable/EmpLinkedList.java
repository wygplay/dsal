package com.datastructure.hashtable;

/**
 * 增、删、改、查
 *
 * @author wyg
 * @version 1.0
 * @date 2021/4/30 20:02
 */
public class EmpLinkedList {
    private Emp first;

    public EmpLinkedList() {
        first = new Emp(-1, "", "");
    }

    public boolean isEmpty() {
        return first.next == null;
    }

    public void add(Emp emp) {
        Emp node = first;
        while (node.next != null) {
            if (node.next.id == emp.id) {
                emp.next = node.next.next;
                node.next = emp;
                return;
            }
            node = node.next;
        }
        node.next = emp;
    }

    public void edit(Emp emp) {
        Emp node = find(emp.id);
        if (node != null) {
            node.name = emp.name;
            node.address = emp.address;
        } else {
            throw new RuntimeException("未找到数据");
        }
    }

    public Emp find(int id) {
        Emp node = first.next;
        while (node != null) {
            if (node.id == id) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    public void remove(int id) {
        Emp node = first;
        while (node.next != null) {
            if (node.next.id == id) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
        throw new RuntimeException("待删除数据未找到");
    }

    public void print() {
        Emp node = first.next;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

}
