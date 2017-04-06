package com.maxGroup.Meeting.lesson12_abstractFactory;

public class JavaDeveloperFactory implements IDeveloperFactory{
    public IDeveloper createDeveloper() {
        return new JavaDeveloper();
    }
}
