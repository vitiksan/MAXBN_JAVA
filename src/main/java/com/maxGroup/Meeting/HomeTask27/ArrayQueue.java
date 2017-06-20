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

    public boolean add(T item) {
        if (index < size - 1) {
            array[++index] = item;
            return true;
        }
        return false;
    }

    public T remove(){
        T temp = (T) array[0];
        for (int i = 0; i<index-1;i++) array[i]=array[i+1];
        index--;
        return temp;
    }
}
