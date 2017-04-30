package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.domain.Account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLAccount <T extends Identificator<PK> , PK extends Serializable> extends AbstractDao<T,PK> {

    public MySQLAccount(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Accounts WHERE id=?;";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Accounts WHERE 1;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Accounts SET type=?,cardNumber=?,balance=?,password=? WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Accounts (id,type,cardNumber,balance,password) VALUES(?,?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Accounts WHERE id =?;";
    }

    @Override
    public ArrayList<T> parsData(ResultSet rs) throws DAOexception {
        ArrayList<T> accounts =new ArrayList<T>();

        try {
            while (!rs.next()) {
                accounts.add((T) new Account(rs.getInt("id"),rs.getDouble("balance"),
                        rs.getInt("password"),
                        rs.getString("cardNumber"),rs.getString("type")));
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return accounts;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, T obj) throws DAOexception {
        Account account = (Account) obj;
        try {
            prSt.setString(1, account.getType());
            prSt.setString(2, account.getCardNumber());
            prSt.setDouble(3,account.getBalance());
            prSt.setInt(4,account.getPass());
            prSt.setInt(5,account.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    protected void parsInsert(PreparedStatement prSt, T obj) throws DAOexception {
        Account account = (Account) obj;
        try {
            prSt.setInt(1,account.getId());
            prSt.setString(2, account.getType());
            prSt.setString(3, account.getCardNumber());
            prSt.setDouble(4,account.getBalance());
            prSt.setInt(5,account.getPass());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}
