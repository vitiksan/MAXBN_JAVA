package com.maxGroup.Meeting.lesson15;

import org.junit.Test;

import static org.junit.Assert.*;


public class GenTest {
    @Test
    public void getObj() throws Exception {
        Gen<Integer> x;
        Gen<String> text;
        x = new Gen<Integer>(3);
        text = new Gen<String>("brain");

        int y = x.getObj();

        System.out.println("x`s type is " + x.toString());
        System.out.println("text`s type is " + text.toString());
    }

}