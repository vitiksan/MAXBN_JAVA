package com.maxGroup.Meeting.HomeTask27;


import java.util.Iterator;
import java.util.LinkedList;

public class WorkWithSystemMethod {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(16);
        list.add(65);
        list.add(56);
        list.add(1965);
        list.add(15);
        System.out.println("size list - " + list.size());
        System.out.println("hashCode - " + list.hashCode());
        System.out.println("index for 65 - " + list.indexOf(65));
        System.out.println("contains 56 - " + list.contains(56));
        System.out.println("remove from list - " + list.remove(list.indexOf(56)));
        System.out.println("contains 56 - " + list.contains(56));

        System.out.println();

        LinkedList<Integer> list1 = (LinkedList<Integer>) list.clone();
        System.out.println("clone list to list1");
        System.out.println("hashCode list - " + list.hashCode());
        System.out.println("hashCode list1 - " + list1.hashCode());

        Iterator<Integer> iterator = list.iterator();
        System.out.println("write list with iterator");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        iterator = list1.iterator();
        System.out.println("write list1 with iterator");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
    }
}
