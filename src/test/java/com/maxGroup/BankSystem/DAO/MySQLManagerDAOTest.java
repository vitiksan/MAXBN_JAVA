package com.maxGroup.BankSystem.DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySQLManagerDAOTest {
    @Test
    public void read() throws Exception {
        MySQL_DAOFactory factory = new MySQL_DAOFactory();
        IManagerDAO managerDAO = factory.getManagerDAO(factory.getConnection());
        System.out.println(managerDAO.read(10).toString());
    }

}