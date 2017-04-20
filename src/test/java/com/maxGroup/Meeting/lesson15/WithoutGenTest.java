package com.maxGroup.Meeting.lesson15;

import org.junit.Test;

import static org.junit.Assert.*;


public class WithoutGenTest {
    @Test
    public void getObject() throws Exception {
        WithoutGen obj1;
        WithoutGen obj2;

        obj1 = new WithoutGen(3);
        obj2 = new WithoutGen("brain");

        int x = (Integer) obj2.getObject();

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
    }

}