package com.maxGroup.Meeting.lesson_26;

import java.util.Collection;

public interface IQueue<T> extends Collection {

    int size();
    boolean addItem(T item);
    T remove();
}
