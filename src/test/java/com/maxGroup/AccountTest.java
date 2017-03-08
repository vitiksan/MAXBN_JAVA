package com.maxGroup;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    @Test //Task 3001
    public void generateVisaCardNumber() throws Exception{
        Account ac = new Account();
        ac.generateVCNumber();
        assertEquals(16, ac.generateVCNumber().length());
        assertEquals("4", String.valueOf(ac.getCardNumber().charAt(0)));
    }
}