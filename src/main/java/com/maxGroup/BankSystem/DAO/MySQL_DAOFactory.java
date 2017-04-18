package com.maxGroup.BankSystem.DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL_DAOFactory implements IDAOFactory {
    private static String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/banksystem?useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";


    private static final Logger log = Logger.getLogger(MySQL_DAOFactory.class);
    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(DRIVERNAME);
            log.info("Драйвер JDBC отримано");
        } catch (ClassNotFoundException e) {
            log.error("Драйвер JDBC не завантажено");
            log.error(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("Успішне підключення до БД");
        } catch (SQLException e) {
            log.error("Не вдалося підключитися до БД");
            log.error(e.getMessage());
        }

        return connection;
    }

    @Override
    public IManagerDAO getManagerDAO(Connection connection) {
        return new MySQLManagerDAO(connection);
    }
}
