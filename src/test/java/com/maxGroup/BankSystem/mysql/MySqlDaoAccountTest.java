package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Account;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySqlDaoAccountTest {
    @Test
    public void createEx() throws Exception {
        Account account = new Account(150000, 12345, "for payments");
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
        Account wroteAccount = (Account) dao.createEx(account,1);
        assertNotNull(wroteAccount);
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
        Account wroteAccount = (Account) dao.read(1);
        assertNotNull(wroteAccount);
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
        ArrayList<Account> wroteAccounts = (ArrayList<Account>) dao.readAll();
        assertNotNull(wroteAccounts);
        assertNotEquals(wroteAccounts.size(), 0);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
        Account account = (Account) dao.read(1);
        account.getMoney(500.50);
        assertTrue(dao.update(account,1));
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
        Account wroteAccount = (Account) dao.read(10);
        assertNotNull(wroteAccount);
        assertTrue(dao.delete(wroteAccount));
    }
}