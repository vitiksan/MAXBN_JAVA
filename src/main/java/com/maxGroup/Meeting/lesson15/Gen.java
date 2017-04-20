package com.maxGroup.Meeting.lesson15;

public class Gen<T> {
    private T obj;

    public Gen(T someObject) {
        this.obj = someObject;
    }

    public T getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "T is "+obj.getClass().getName();
    }
}
