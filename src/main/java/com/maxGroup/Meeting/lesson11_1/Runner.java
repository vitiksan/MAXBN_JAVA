package com.maxGroup.Meeting.lesson11_1;

public class Runner {
    public static void main(String[] args) {
        Factory.serviceCreator(new ImplFactory1());
        Factory.serviceCreator(new ImplFactory2());
    }
}
