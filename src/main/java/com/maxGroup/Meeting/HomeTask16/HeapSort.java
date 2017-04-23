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


    public T[] sort() {
        int index = 0;
        int temp = 0;
        boolean replacing = false;
        try {
            while (size != 1) {
                if (arr[index].doubleValue() < arr[2 * index + 1].doubleValue() && arr[2 * index + 1].doubleValue() > arr[2 * index + 2].doubleValue()) {
                    replacing = replace(index, 2 * index + 1);
                    if (!replacing) throw new Exception("can`t replace number");
                } else if (arr[index].doubleValue() < arr[2 * index + 2].doubleValue() && arr[2 * index + 2].doubleValue() > arr[2 * index + 1].doubleValue()) {
                    replacing = replace(index, 2 * index + 2);
                    if (!replacing) throw new Exception("can`t replace number");
                }

                if (2 * index + 1 < size) index = 2 * index + 1;
                else if (2 * index + 2 < size) index = 2 * index + 2;

                if (replacing && index == 0) {
                    replace(index, size - 1);
                    size--;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return arr;
    }
}