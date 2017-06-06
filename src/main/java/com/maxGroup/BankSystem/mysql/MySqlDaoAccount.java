package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MySqlDaoAccount extends AbstractDao<Account, Integer> {

    private class ExtendAccount extends Account {
        @Override
        protected void setId(int id) {
            super.setId(id);
        }

        @Override
        protected void setExpCard(GregorianCalendar expCard) {
            super.setExpCard(expCard);
        }

        @Override
        protected void setCardNumber(String numberAccount) {
            super.setCardNumber(numberAccount);
        }

        @Override
        protected void setBalance(double balance) {
            super.setBalance(balance);
        }

        @Override
        protected void setPass(int pass) {
            super.setPass(pass);
        }
    }

    public MySqlDaoAccount(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM accounts";
    }

    @Override
    public String getSelectAllQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE accounts SET account_type=?,cardNumber=?,balance=?,password=?,validity=? customer_id=? WHERE account_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO accounts (account_type,cardNumber,balance,password,validity,customer_id) VALUES(?,?,?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM accounts WHERE account_id =?;";
    }

    @Override
    public ArrayList<Account> parsData(ResultSet rs) throws DAOexception {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            while (rs.next()) {
                ExtendAccount account = new ExtendAccount();
                account.setId(rs.getInt("account_id"));
                account.setCardNumber(rs.getString("cardNumber"));
                account.setBalance(rs.getDouble("balance"));
                account.setPass(rs.getInt("password"));
                account.setType(rs.getString("account_type"));
                account.setCustomer_id(rs.getInt("customer_id"));
                account.setExpCard(convertToGregorianCalendar(rs.getDate("validity")));
                accounts.add(account);
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return accounts;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Account obj,int key) throws DAOexception {
        try {
            prSt.setString(1, obj.getType());
            prSt.setString(2, obj.getCardNumber());
            prSt.setDouble(3, obj.getBalance());
            prSt.setInt(4, obj.getPass());
            prSt.setDate(5, convertToSqlDate(obj.getExpCard()));
            prSt.setInt(6,obj.getCustomer_id());
            prSt.setInt(7, obj.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Account obj,int key) throws DAOexception {
        try {
            prSt.setString(1, obj.getType());
            prSt.setString(2, obj.getCardNumber());
            prSt.setDouble(3, obj.getBalance());
            prSt.setInt(4, obj.getPass());
            prSt.setDate(5, convertToSqlDate(obj.getExpCard()));
            prSt.setInt(6,obj.getCustomer_id());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}