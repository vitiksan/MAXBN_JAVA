package com.maxGroup.BankSystem.supportClass;

import com.maxGroup.BankSystem.domain.Human;

public class GenQueue<T extends Human> {
    private T[] queue;
    private int size;
    private int index;

    public GenQueue(T[] queue) {
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

    public String showAll(){
        String temp = "";
        for (T item: queue){
            temp +=item.toString()+"\n";
        }
        return temp;
    }

    public int getSize() {
        return size;
    }
}
