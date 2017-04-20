package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.AccountFactory.IAccount;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLAccountDao implements IAccountDao {
    private final Connection connection;
    private final String READ = "SELECT * FROM Accounts WHERE id = ?;";
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
            log.error("Не вдалося додати акаунт");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
    }

    @Override
    public IAccount read(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(IAccount manager) throws SQLException {
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
            log.error("Не вдалося отримати дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<IAccount> getAll() throws SQLException {
        return null;
    }
}
