package com.maxGroup.Meeting.HomeTask13;

import java.util.ArrayList;

public class IntQueue implements IIntQueue {
    ArrayList<Integer> queue;

    public IntQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public void push(int item) {
        queue.add(item);
    }

    @Override
    public int pop() {
        int temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    @Override
    public int top() {
        return queue.get(0);
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return (queue.size() < 1);
    }
}
