package com.maxGroup.BankSystem.DAO;

import org.junit.Test;

public class MySQLManagerDAOTest {
    @Test
    public void read() throws Exception {
        MySQLManagerDAOFactory factory = new MySQLManagerDAOFactory();
        IManagerDAO managerDAO = factory.getManagerDAO(factory.getConnection());
        System.out.println(managerDAO.read(10).toString());
    }

}