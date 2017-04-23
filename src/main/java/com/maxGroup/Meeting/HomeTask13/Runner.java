package com.maxGroup.Meeting.HomeTask13;

public class Runner {
    public static void main(String[] args) {
        IQueue arr = new IntQueue(20);
        arr.push(2);
        arr.push(5);
        arr.push(7);
        arr.push(8);
        System.out.println(arr.first() + "  " + arr.pop());
        while (!arr.isFull()) arr.push(10);
        while (!arr.isEmpty()) {
            System.out.println(arr.pop());
        }
    }
}
