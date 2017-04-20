package com.maxGroup.Meeting.lesson15;

public class WithoutGen {
    Object object;

    public WithoutGen(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "T is "+object.getClass().getName();
    }
}
