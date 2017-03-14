package com.maxGroup;

import com.maxGroup.BankSystem.Customer;
import org.junit.Test;

import java.util.ArrayList;

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