package com.datastructure.hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/30 23:07
 */
public class EmpHashtableTest {

    public EmpHashtable hashtable;

    @Before
    public void init() {
        hashtable = new EmpHashtable();
        Emp emp = new Emp(1, "wyg", "hz");
        hashtable.add(emp);
    }

    @Test
    public void add() {
        Emp emp = new Emp(1, "is", "hz");
        hashtable.add(emp);
    }

    @Test
    public void remove() {
        hashtable.remove(1);
    }

    @Test
    public void edit() {
        Emp emp = new Emp(1, "edited", "hz");
        hashtable.edit(emp);
    }

    @Test
    public void find() {
        System.out.println(hashtable.find(1));
    }
    @After
    public void print() {
        hashtable.print();
    }
}