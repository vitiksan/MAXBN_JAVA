package com.maxGroup.Meeting.HomeTask27;

public class MyArrayList<T> {
    private Object[] array;
    private int index = -1;
    private int size;

    public MyArrayList() {
        array = new Object[20];
        size = 20;
    }

    public MyArrayList(int size) {
        array = new Object[size];
        this.size = size;
    }

    public void add(T element) {
        if (index == size - 1) resize(size * 2);
        array[++index] = element;
    }

    public T get(int index) {
        if (index > this.index) return null;
        return (T) array[index];
    }

    public void delete(int index) {
        for (int i = index; i < this.index - 1; i++) {
            array[i] = array[i + 1];
        }
        this.index--;
        if (this.index < (size / 2) - 1) resize(size / 2);
    }

    private void resize(int size) {
        Object[] temp = new Object[size];
        System.arraycopy(array, 0, temp, 0, index + 1);
        this.size = size;
    }
}
