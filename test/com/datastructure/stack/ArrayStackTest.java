package com.datastructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
    ArrayStack arrayStack;
    @Before
    public void init() {
        arrayStack = new ArrayStack(5 );
        arrayStack.push("wyg");
    }

    @Test
    public void push() {
        arrayStack.push("is");
        assertEquals(arrayStack.getSize(), 2);
    }

    @Test
    public void pop() {
        assertEquals(arrayStack.pop(), "wyg");
        assertEquals(arrayStack.getSize(), 0);
    }

    @Test
    public void getTop() {
        assertEquals(arrayStack.getTop(), "wyg");
        assertEquals(arrayStack.getSize(), 1);
    }

    @Test
    public void charTest() {
        char a = '1';
        System.out.println(a);
    }
}