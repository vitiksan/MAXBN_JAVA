package com.maxGroup.BankSystem.DAO;


import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOAccountFactory {
    Connection getConnection() throws SQLException;
    IAccountDAO getAccountDAO(Connection connection);
}
