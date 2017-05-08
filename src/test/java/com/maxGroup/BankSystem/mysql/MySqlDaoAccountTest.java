package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySqlDaoAccountTest {
    @Test
    public void createEx() throws Exception {
        Account account = new Account(150000, 12345,"for payments");
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(),Account.class);
        Account wroteAccount = (Account) dao.createEx(account);
        assertNotNull(wroteAccount);
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void readAll() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }


}