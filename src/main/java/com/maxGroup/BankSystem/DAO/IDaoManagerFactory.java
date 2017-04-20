package com.maxGroup.BankSystem.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoManagerFactory {
    Connection getConnection() throws SQLException;
    IManagerDao getManagerDAO(Connection connection);
}
