package com.maxGroup.Meeting.HomeTask16;

import org.apache.log4j.Logger;

public class HeapSort<T extends Number> {
    private T[] arr;
    int size;

    private static final Logger log = Logger.getLogger(HeapSort.class);

    public HeapSort(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
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

    public T[] heapSort() {

        for (int i = size / 2 - 1; i >= 0; i--) downHeap(i, size - 1);

        for (int i = size - 1; i > 0; i--) {
            replace(0, i);
            downHeap(0, i - 1);
        }
        return arr;
    }


    private void downHeap(int index, int lim) {
        T temp = arr[index];
        int child;

        while (index <= (size -1)/2) {
            child = 2 * index;
            if (child < lim && arr[child].doubleValue() < arr[child + 1].doubleValue())
                child++;
            if (temp.doubleValue() >= arr[child].doubleValue()) break;
            replace(index,child);
            index = child;
        }
    }
}
