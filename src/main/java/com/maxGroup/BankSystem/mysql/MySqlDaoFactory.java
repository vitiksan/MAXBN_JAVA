package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.DAO.IdaoFactory;
import com.maxGroup.BankSystem.domain.Account;
import com.maxGroup.BankSystem.domain.Customer;
import com.maxGroup.BankSystem.domain.Manager;
import com.maxGroup.BankSystem.domain.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements IdaoFactory<Connection> {
    private String DRIVERNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua/servlab_devmax?useSSL=false";
    private String USERNAME = "servlab_devmax";
    private String PASSWORD = "f843xa4x";
    public Map<Class, DaoCreator> allDaoClass;

    @Override
    public Connection getConnection() throws DAOexception {
        Connection connection = null;

        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            throw new DAOexception(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DAOexception(e);
        }
        return connection;
    }

    @Override
    public IGenDao getDAO(Connection connection, Class daoClass) throws DAOexception {
        DaoCreator creator = allDaoClass.get(daoClass);
        if (creator == null) {
            throw new DAOexception("Can't found dao object for " + daoClass);
        }
        return creator.create(connection);
    }

    public MySqlDaoFactory() {
        allDaoClass = new HashMap<Class, DaoCreator>();

        allDaoClass.put(Account.class, new DaoCreator<Connection>() {
            @Override
            public IGenDao create(Connection connection) {
                return new MySqlDaoAccount(connection);
            }
        });
        allDaoClass.put(Manager.class, new DaoCreator<Connection>() {
            @Override
            public IGenDao create(Connection connection) {
                return new MySqlDaoManager(connection);
            }
        });
        allDaoClass.put(Customer.class, new DaoCreator<Connection>() {
            @Override
            public IGenDao create(Connection connection) {
                return new MySqlDaoCustomer(connection);
            }
        });
        allDaoClass.put(Transaction.class, new DaoCreator<Connection>() {
            @Override
            public IGenDao create(Connection connection) {
                return new MySqlDaoTransaction(connection);
            }
        });
    }
}
