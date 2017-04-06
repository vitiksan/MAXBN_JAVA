package com.maxGroup.Meeting.lesson12_abstractFactory;

public class QaTesterFactory implements ITesterFactory {
    public ITester createTester() {
        return new QaTester();
    }
}
