package com.maxGroup.BankSystem.supportClass;

import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Customer;
import com.maxGroup.BankSystem.domain.Transaction;
import com.maxGroup.BankSystem.mysql.MySqlDaoFactory;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class UsersFromTransaction {

    public abstract int getId(Transaction transaction);

    public HashSet<Customer> getUser() throws DAOexception {
        HashSet<Integer> id = new HashSet<>();
        HashSet<Customer> customers = new HashSet<>();
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Transaction.class);
        ArrayList<Transaction> transactions = dao.readAll();
        for (Transaction transaction : transactions) id.add(getId(transaction));

        dao = factory.getDAO(factory.getConnection(), Customer.class);
        for (Integer value : id) customers.add((Customer) dao.read(value));

        return customers;
    }
}
