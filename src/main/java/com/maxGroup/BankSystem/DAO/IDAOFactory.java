package com.maxGroup.BankSystem.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOFactory {
    Connection getConnection() throws SQLException;
    IManagerDAO getManagerDAO(Connection connection);
}
