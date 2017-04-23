package com.maxGroup.Meeting.HomeTask16;

public class Runner {
    public static void main(String[] args) {
        Integer[] arr = {55, 2, 93, 16, 10, 59, 12, 7};
        HeapSort heapSort = new HeapSort(arr);
        arr = (Integer[]) heapSort.sort();
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
