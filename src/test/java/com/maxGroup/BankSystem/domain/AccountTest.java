package com.maxGroup.BankSystem.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void generateCardNumber() throws Exception {
        Account account = new Account();
        Account account1 = new Account();

        System.out.println(account.getCardNumber());
        System.out.println(account1.getCardNumber());
        assertNotEquals(account.getCardNumber(),account1.getCardNumber());
    }

}