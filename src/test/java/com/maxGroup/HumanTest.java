package com.maxGroup;

import com.maxGroup.BankSystem.domain.Customer;
import org.junit.Test;

import java.util.ArrayList;

public class HumanTest {
    @Test
    public void arrayListTest() throws Exception {
        ArrayList<Customer> people = new ArrayList<Customer>();

        for (int i = 0; i < 10; i++) {
            people.add(new Customer());
        }

        for (Object item : people) {
            System.out.println(item.toString());
        }
    }

}