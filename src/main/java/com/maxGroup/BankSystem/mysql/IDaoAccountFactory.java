package com.maxGroup.BankSystem.mysql;


import com.maxGroup.BankSystem.mysql.IAccountDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoAccountFactory {
    Connection getConnection() throws SQLException;
    IAccountDao getAccountDAO(Connection connection);
}
