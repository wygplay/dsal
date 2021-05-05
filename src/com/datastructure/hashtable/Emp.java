package com.datastructure.hashtable;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/30 20:01
 */
public class Emp {
    public int id;
    public String name;
    public String address;
    public Emp next;
    public Emp() {}
    public Emp(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
