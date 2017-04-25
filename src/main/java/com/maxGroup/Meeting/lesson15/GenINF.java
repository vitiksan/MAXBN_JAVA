package com.maxGroup.Meeting.lesson15;

public class GenINF<T extends Comparable<T>> implements MinMax<T> {
    T[] values;

    public GenINF(T[] values) {
        this.values = values;
    }

    @Override
    public T min() {
        T valueTemp = values[0];

        for (int i = 0; i < values.length; i++) {
            if (values[i].compareTo(valueTemp) > 0) valueTemp = values[i];
        }

        return valueTemp;
    }

    @Override
    public T max() {

        T valueTemp = values[0];

        for (int i = 0; i < values.length; i++) {
            if (values[i].compareTo(valueTemp) < 0) valueTemp = values[i];
        }

        return valueTemp;
    }
}
