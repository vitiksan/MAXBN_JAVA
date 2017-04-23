package com.maxGroup.Meeting.HomeTask13;

public class IntQueue {
    private int[] queue;
    private int size;
    private int index;

    public IntQueue(int size) {
        queue = new int[size];
        this.size = size;
        index = -1;
    }

    public IntQueue() {
        queue = new int[10];
        size = 10;
        index = -1;
    }

    public void push(int item) {
        queue[++index] = item;
    }

    public int pop() {
        int temp = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        index--;
        return temp;
    }

    public int first() {
        return queue[0];
    }

    public boolean isFull() {
        return (index >= size - 1);
    }

    public boolean isEmpty() {
        return (index < 0);
    }
}
