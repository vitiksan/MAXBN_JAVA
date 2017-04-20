package com.maxGroup.Meeting.lesson15;

import java.io.Serializable;

public class Status<T extends Number & Comparable & Serializable> {
    T[] arr;

    public Status(T[] arr) {
        this.arr = arr;
    }

    public double avg() {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=  arr[i].doubleValue();
        }
        return sum / arr.length;
    }

    boolean compareAvg(Status<? extends Number> obj){
        if(avg() == obj.avg())return true;
        return false;
    }
}
