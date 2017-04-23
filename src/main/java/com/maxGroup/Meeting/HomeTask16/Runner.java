package com.maxGroup.Meeting.HomeTask16;

public class Runner {
    public static void main(String[] args) {
        Integer[] arr = {2, 5, 8, 2, 8, 5, 8, 4, 9, 4};
        HeapSort heapSort = new HeapSort(arr);
        arr = (Integer[]) heapSort.heapSort();
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
