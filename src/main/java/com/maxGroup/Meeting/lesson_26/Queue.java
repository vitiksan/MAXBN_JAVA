package com.maxGroup.Meeting.lesson_26;

import java.util.AbstractCollection;
import java.util.AbstractList;

public class Queue<T> extends AbstractList implements  IQueue<T>{
    @Override
    public Object get(int index) {
        return null;
    }

    private  class  Node{
        T element;
        Node next;
    }
    private  int size = 0;
    private  Node first;//посилання на старий елемент
    private  Node last;//посилання на новий елемент

    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addItem(T item) {
        Node oldLast = last;
        last = new Node();
        last.element=item;
        last.next = null;
        if (isEmpty()) first=last;
        else oldLast.next=last;
        size++;
        return true;
    }

    @Override
    public T remove() {
        T item = first.element;
        first = first.next;
        if (isEmpty()) last =null;
        size--;
        return item;
    }
}
