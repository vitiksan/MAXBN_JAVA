package com.maxGroup.BankSystem.supportClass;

import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Customer;
import com.maxGroup.BankSystem.domain.Transaction;
import com.maxGroup.BankSystem.mysql.MySqlDaoFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class SenderAndRecipient {
    //TODO 29.02 - Try add abstract class
    public static ArrayList<Customer> getRecipient() throws DAOexception {
        HashSet<Integer> id = new HashSet<>();
        ArrayList<Customer> customers = new ArrayList<>();
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Transaction.class);
        ArrayList<Transaction> transactions = dao.readAll();
        for (Transaction transaction : transactions) id.add(transaction.getAccountIdTo());

        dao = factory.getDAO(factory.getConnection(), Customer.class);
        for (Integer value : id) customers.add((Customer) dao.read(value));

        return customers;
    }

    public static ArrayList<Customer> getSender() throws DAOexception {
        HashSet<Integer> id = new HashSet<>();
        ArrayList<Customer> customers = new ArrayList<>();
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Transaction.class);
        ArrayList<Transaction> transactions = dao.readAll();
        for (Transaction transaction : transactions) id.add(transaction.getAccountIdFrom());

        dao = factory.getDAO(factory.getConnection(), Customer.class);
        for (Integer value : id) customers.add((Customer) dao.read(value));

        return customers;
    }
}
