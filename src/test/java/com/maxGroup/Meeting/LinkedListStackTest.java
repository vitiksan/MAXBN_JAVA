package com.maxGroup.Meeting;

import org.junit.Test;

import static org.junit.Assert.*;


public class LinkedListStackTest {
    @Test
    public void push() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(5);
        stack.push(7);
        stack.push(4);
        while (!stack.isEmpty())
        System.out.println(stack.pop());
    }
}