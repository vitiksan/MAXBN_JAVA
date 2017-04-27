package com.maxGroup.BankSystem.supportClass;



public class Queue<T> {
    private T[] queue;
    private int size;
    private int index;

    public Queue(T[] queue) {
        this.queue = queue;
        this.size = queue.length;
        index = -1;
    }

    public void push(T item) {
        queue[++index] = item;
    }

    public T pop() {
        T temp = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        index--;
        return temp;
    }

    public T first() {
        return queue[0];
    }

    public boolean isFull() {
        return (index >= size - 1);
    }

    public boolean isEmpty() {
        return (index < 0);
    }

}
