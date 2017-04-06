package com.maxGroup.Meeting.lesson12_abstractFactory;

public class QcTesterFactory implements ITesterFactory {
    public ITester createTester() {
        return new QcTester();
    }
}
