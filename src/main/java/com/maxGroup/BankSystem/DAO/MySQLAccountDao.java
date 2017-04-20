package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.AccountFactory.AccFactory;
import com.maxGroup.BankSystem.AccountFactory.IAccount;
import com.maxGroup.BankSystem.AccountFactory.IAccountFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLAccountDao implements IAccountDao {
    private final Connection connection;
    private final String READ = "SELECT * FROM Accounts WHERE id = ?;";
    private final String READALL = "SELECT * FROM Accounts WHERE 1;";
    private final String CREATE = "INSERT INTO Accounts (id,type,cardNumber,balance,password) VALUES(?,?,?,?,?);";
    private final String UPDATE = "UPDATE Accounts SET balance=? WHERE id =?;";
    private final String DELETE = "DELETE FROM Accounts WHERE id =?;";

    private static final Logger log = Logger.getLogger(MySQLAccountDao.class);

    public MySQLAccountDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(IAccount account) throws SQLException {
        PreparedStatement prSt = null;

        try {
            prSt = connection.prepareStatement(CREATE);

            prSt.setInt(1, account.getAccountId());
            prSt.setString(2, account.getType());
            prSt.setString(3, account.getCardNumber());
            prSt.setDouble(4, account.getBalance());
            prSt.setInt(4, account.getPass());

            prSt.execute();

        } catch (SQLException e) {
            log.error("Не вдалося додати аккаунт до бази даних");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
    }

    @Override
    public IAccount read(int id) throws SQLException {
        PreparedStatement prSt = null;
        IAccount account = null;

        try {
            prSt = connection.prepareStatement(READ);
            prSt.setInt(1, id);
            ResultSet resultSet = prSt.executeQuery();

            IAccountFactory factory = AccFactory.createAccountFactory(resultSet.getString("type"));
            account = factory.createAccount(resultSet.getDouble("balance"),
                    resultSet.getInt("password"),
                    resultSet.getString("cardNumber"));


        } catch (SQLException e) {
            log.error("Не вдалося отримати дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
        return account;
    }

    @Override
    public void update(IAccount account) throws SQLException {
        PreparedStatement prSt = null;

        try {
            prSt = connection.prepareStatement(UPDATE);

            prSt.setDouble(1, account.getBalance());
            prSt.setInt(2, account.getAccountId());

            prSt.execute();

        } catch (SQLException e) {
            log.error("Не вдалося оновити дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement prSt = null;

        try {
            prSt = connection.prepareStatement(DELETE);

            prSt.setInt(1, id);
            prSt.execute();

        } catch (SQLException e) {
            log.error("Не вдалося видалити аккаунт з бази даних");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
    }

    @Override
    public List<IAccount> getAll() throws SQLException {
        PreparedStatement prSt = null;
        List<IAccount> accounts = null;

        try {
            prSt = connection.prepareStatement(READALL);
            ResultSet resultSet = prSt.executeQuery();

            while (!resultSet.next()) {
                IAccountFactory factory = AccFactory.createAccountFactory(resultSet.getString("type"));
                accounts.add(factory.createAccount(resultSet.getDouble("balance"),
                        resultSet.getInt("password"),
                        resultSet.getString("cardNumber")));
            }

        } catch (SQLException e) {
            log.error("Не вдалося отримати дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
        return accounts;
    }
}
