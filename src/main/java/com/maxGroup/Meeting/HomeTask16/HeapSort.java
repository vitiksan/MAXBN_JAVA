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

    private boolean sortThreeElement(int index) {
        boolean replacing = false;
        int left = 1;
        int right = 2;
        try {
            if (arr[index].doubleValue() < arr[2 * index + 1].doubleValue() && arr[2 * index + 1].doubleValue() > arr[2 * index + 2].doubleValue()) {
                replacing = replace(index, 2 * index + 1);
                if (!replacing) throw new Exception();
            } else if (arr[index].doubleValue() < arr[2 * index + 2].doubleValue() && arr[2 * index + 2].doubleValue() > arr[2 * index + 1].doubleValue()) {
                replacing = replace(index, 2 * index + 2);
                if (!replacing) throw new Exception();
            }

            left = 2 * index + 1;
            right = 2 * index + 2;
            if (2 * left + 1 < size) {
                sortThreeElement(left);
            } else if (2 * right + 2 < size) {
                sortThreeElement(right);
            }

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error("can`t replace");
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return replacing;
    }


    public T[] sort() {
        int index = 0;
        boolean replacing = false;

        while (size != 1) {
            sortThreeElement(index);
            if (replacing && index == 0) {
                replace(index, size - 1);
                size--;
            }
        }
        return arr;
    }
}
