package com.maxGroup.Meeting.lesson7;

import java.util.ArrayList;

public class lesson7_1 {
    public static void main(String[] args) {
        int a = 10;
        int f = 15;
        Integer b = 10;
        Integer d = 20;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);

        int c = list.get(0);

        summ(1,8,7,9,6,4);
        summ(9,8,7,8,6,1);

    }

    public static void summ(int... args) {
        int summ = 0;
        for (int number : args) {
            summ += number;
        }
        System.out.println("Summ = " + summ);
    }
}
