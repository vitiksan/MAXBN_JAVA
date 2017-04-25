package com.maxGroup.Meeting.HomeTask16;

public class Runner {
    public static void main(String[] args) {
        Integer[] arr = {55, 2, 93, 16, 10, 59, 12, 7};
        Double[] arr1 = {20.3,25.8,20.5,50.0,34.2};
        HeapSort<Integer> heapSort = new HeapSort(arr);
        HeapSort<Double> heapSort1 = new HeapSort(arr1);

        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        arr = (Integer[]) heapSort.sort();
        System.out.print("\t------\t");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();

        for (Double i : arr1) {
            System.out.print(i + " ");
        }
        arr1 = (Double[]) heapSort1.sort();
        System.out.print("\t------\t");
        for (Double i : arr1) {
            System.out.print(i + " ");
        }
    }
}
