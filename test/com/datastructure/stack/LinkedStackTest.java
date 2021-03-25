package com.datastructure.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {
    LinkedStack linkedStack;
    @Before
    public void init() {
        linkedStack = new LinkedStack();
        linkedStack.push("wyg");
    }
    @Test
    public void push() {
        linkedStack.push("test");
    }

    @Test
    public void pop() {
        System.out.println(linkedStack.pop());
    }

    @Test
    public void getTop() {
        System.out.println(linkedStack.getTop());
    }

    @Test
    public void isEmpty() {
        linkedStack.pop();
        assertTrue(linkedStack.isEmpty());
    }

    @After
    public void close() {
        linkedStack.show();
    }
}