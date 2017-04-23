package com.maxGroup.Meeting.HomeTask16;

import org.apache.log4j.Logger;

public class HeapSort<T extends Number> {
    private T[] arr;
    int size;
    private int left;
    private int right;
    private int largest;

    private static final Logger log = Logger.getLogger(HeapSort.class);

    public HeapSort(T[] arr) {
        this.arr = arr;
        this.size = arr.length-1;
    }

    private boolean replace(int x, int y) {
        if (x < size && y < size) {
            T temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            return true;
        }
        return false;
    }

}
