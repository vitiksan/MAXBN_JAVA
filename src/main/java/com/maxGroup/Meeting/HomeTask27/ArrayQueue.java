package com.maxGroup.Meeting.HomeTask27;

public class ArrayQueue<T> {
    private Object[] array;
    private int index = -1;
    private int size;


    public ArrayQueue() {
        size = 10;
        array = new Object[size];
    }

    public ArrayQueue(int size) {
        this.size = size;
        array = new Object[size];
    }
}
