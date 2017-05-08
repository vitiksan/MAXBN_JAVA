package com.maxGroup.BankSystem.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void generateCardNumber() throws Exception {
        Account account = new Account();
        Account account1 = new Account();

        assertNotEquals(account.getCardNumber(),account1.getCardNumber());
    }

}