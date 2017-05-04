package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlDaoAccount extends AbstractDao<Account,Integer> {

    private class ExtendAccount extends Account{
        @Override
        protected void setId(int id) {
            super.setId(id);
        }
    }

    public MySqlDaoAccount(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Accounts;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Accounts SET type=?,cardNumber=?,balance=?,password=? WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Accounts (type,cardNumber,balance,password) VALUES(?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Accounts WHERE id =?;";
    }

    @Override
    public ArrayList<Account> parsData(ResultSet rs) throws DAOexception {
        ArrayList<Account> accounts =new ArrayList<Account>();

        try {
            while (!rs.next()) {
                ExtendAccount account = new ExtendAccount();
                account.setId(rs.getInt("id"));
                account.setCardNumber(rs.getString("cardNumber"));
                account.setBalance(rs.getDouble("balance"));
                account.setPass(rs.getInt("password"));
                account.setType(rs.getString("type"));
                accounts.add(account);
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return accounts;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Account obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getType());
            prSt.setString(2, obj.getCardNumber());
            prSt.setDouble(3,obj.getBalance());
            prSt.setInt(4,obj.getPass());
            prSt.setInt(5,obj.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Account obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getType());
            prSt.setString(2, obj.getCardNumber());
            prSt.setDouble(3,obj.getBalance());
            prSt.setInt(4,obj.getPass());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}
