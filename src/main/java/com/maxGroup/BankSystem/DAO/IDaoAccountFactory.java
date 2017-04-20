package com.maxGroup.BankSystem.DAO;


import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoAccountFactory {
    Connection getConnection() throws SQLException;
    IAccountDao getAccountDAO(Connection connection);
}
