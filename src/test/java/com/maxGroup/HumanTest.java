package com.maxGroup;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void arraListTest() throws Exception {
        ArrayList<Customer> people = new ArrayList<Customer>();

        for (int i = 0; i < 10; i++) {
            people.add(new Customer());
        }

        for (Object item : people) {
            System.out.println(item.toString());
        }
    }

}