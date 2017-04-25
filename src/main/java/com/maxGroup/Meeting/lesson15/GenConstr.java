package com.maxGroup.Meeting.lesson15;

public class GenConstr {
    private double val;

    public <T extends Number> GenConstr(T args) {
        val = args.doubleValue();
    }
}
