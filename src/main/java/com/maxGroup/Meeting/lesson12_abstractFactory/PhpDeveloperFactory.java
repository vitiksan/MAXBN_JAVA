package com.maxGroup.Meeting.lesson12_abstractFactory;

public class PhpDeveloperFactory implements IDeveloperFactory {
    public IDeveloper createDeveloper() {
        return new PhpDeveloper();
    }
}
