package com.maxGroup.Meeting.HomeTask16;

import org.apache.log4j.Logger;

public class HeapSort<T extends Number> {
    private T[] arr;
    int count;
    private int left;
    private int right;
    private int largest;

    private static final Logger log = Logger.getLogger(HeapSort.class);

    public HeapSort(T[] arr) {
        this.arr = arr;
        this.count = arr.length;
    }

    private void replace(int x, int y) {
            T temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
    }

    public T[] sort(){
        build();

        for(int i = count; i>0; i--) {
            replace(0, i);
            count--;
            maxheap(0);
        }
        return arr;
    }

    public void maxheap(int i) {
        left = 2*i;
        right = 2*i+1;

        if(left <= count && arr[left].doubleValue() > arr[i].doubleValue()){
            largest=left;
        } else {
            largest=i;
        }

        if(right <= count && arr[right].doubleValue() > arr[largest].doubleValue()) {
            largest=right;
        }
        if(largest!=i) {
            replace(i, largest);
            maxheap(largest);
        }
    }

    public void build(){
        count--;
        for(int i = count /2; i>=0; i--){
            maxheap(i);
        }
    }
}