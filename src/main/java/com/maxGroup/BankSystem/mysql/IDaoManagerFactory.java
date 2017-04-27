package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.mysql.IManagerDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoManagerFactory {
    Connection getConnection() throws SQLException;
    IManagerDao getManagerDAO(Connection connection);
}
