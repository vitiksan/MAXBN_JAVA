package com.maxGroup.Meeting.lesson15;


public class GenV2<T,Y> {
    private T x;
    private Y y;

    public GenV2(T x, Y y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    @Override
    public String toString() {
        return "T is "+x.getClass().getName()+
                "Y is "+y.getClass().getName();
    }
}
