package com.maxGroup.BankSystem.domain;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void hashCodeTest() throws Exception {
        Customer cm1 = new Customer("Nazar", "Mh", new GregorianCalendar(1990,07,30),
                10, "JavaGuru", "Beach", 20);
        Customer cm2 = new Customer("Nazar", "Mh", new GregorianCalendar(1990,07,30),
                11, "JavaGuru", "Beach", 20);

        System.out.println(cm1.hashCode());
        System.out.println(cm2.hashCode());
    }

}