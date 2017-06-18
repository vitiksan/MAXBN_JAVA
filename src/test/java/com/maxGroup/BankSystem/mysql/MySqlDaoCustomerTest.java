package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;


public class MySqlDaoCustomerTest {
    @Test
    public void createEx() throws Exception {
        Customer customer = new Customer();
        customer.setName("vitalik");
        customer.setSurname("mah");
        customer.setBorn(new GregorianCalendar(1997,11,29));
        customer.setAddress("if");
        customer.setStatusCustomer("basic");
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
        Customer wroteCustomer = (Customer) dao.createEx(customer);
        assertNotNull(wroteCustomer);
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
        Customer wroteCustomer = (Customer) dao.read(1);
        assertNotNull(wroteCustomer);
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
        ArrayList<Customer> wroteCustomers = (ArrayList<Customer>) dao.readAll();
        assertNotNull(wroteCustomers);
        assertNotEquals(wroteCustomers.size(), 0);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
        Customer customer = (Customer) dao.read(1);
        customer.setName("vasa");
        assertTrue(dao.update(customer));
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
        Customer wroteCustomer = (Customer) dao.read(10);
        assertNotNull(wroteCustomer);
        assertTrue(dao.delete(wroteCustomer));
    }

}