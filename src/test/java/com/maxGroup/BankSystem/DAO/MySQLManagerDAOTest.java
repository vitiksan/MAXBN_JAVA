package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.mysql.IManagerDao;
import com.maxGroup.BankSystem.mysql.MySQLManagerDaoFactory;
import org.junit.Test;

public class MySQLManagerDAOTest {
    @Test
    public void read() throws Exception {
        MySQLManagerDaoFactory factory = new MySQLManagerDaoFactory();
        IManagerDao managerDAO = factory.getManagerDAO(factory.getConnection());
        System.out.println(managerDAO.read(10).toString());
    }

}