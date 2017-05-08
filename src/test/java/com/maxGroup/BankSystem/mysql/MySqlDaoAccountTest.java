package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Account;
import org.junit.Test;

import java.util.ArrayList;

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
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(),Account.class);
        Account wroteAccount = (Account) dao.read(1);
        assertNotNull(wroteAccount);
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(),Account.class);
        ArrayList<Account> wroteAccounts = (ArrayList<Account>) dao.readAll();
        assertNotNull(wroteAccounts);
        assertNotEquals(wroteAccounts.size(),0);
    }

    @Test
    public void update() throws Exception {
        Account account = new Account(150000, 12345,"for payments");
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(),Account.class);
        dao.update(account);
        Account wroteAccount = (Account) dao.read(account.getId());
        assertNotNull(wroteAccount);
        assertEquals(account.getBalance(),wroteAccount.getBalance(),0.5);
        assertEquals(account.getCardNumber(),wroteAccount.getCardNumber());
        assertEquals(account.getType(),wroteAccount.getType());
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(),Account.class);
        Account wroteAccount = (Account) dao.read(10);
        assertNotNull(wroteAccount);
        dao.delete(wroteAccount);
        Account deleteAccount = (Account) dao.read(10);
        assertNull(deleteAccount);
    }
}