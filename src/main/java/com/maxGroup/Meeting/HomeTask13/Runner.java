package com.maxGroup.Meeting.HomeTask13;

public class Runner {
    public static void main(String[] args) {
        IIntQueue arr = new IntQueue();
        arr.push(2);
        arr.push(5);
        arr.push(7);
        arr.push(8);
        System.out.println(arr.top() + "  " + arr.pop());
        while (!arr.isEmpty()) {
            System.out.println(arr.pop());
        }
        System.out.println("size after delete: " + arr.getSize());
    }
}
