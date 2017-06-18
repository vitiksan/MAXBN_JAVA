package com.maxGroup.Meeting;

public class LinkedListStack<T> {
    private class Node {
        T element;
        Node next;
    }

    private int size = 0;
    private Node first;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node n = new Node();
        n.element = item;
        n.next = first;
        first = n;
    }

    public T pop() {
        Node temp = first;
        while (!isEmpty()) {
            first = first.next;
        }
        return temp.element;
    }


}
