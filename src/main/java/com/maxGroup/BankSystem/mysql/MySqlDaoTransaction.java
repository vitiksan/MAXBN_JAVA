package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlDaoTransaction  extends AbstractDao<Transaction, Integer> {
    public MySqlDaoTransaction(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM transactions WHERE transaction_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM transactions;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE transactions SET account_id_from=?,account_id_to=?,amount=? WHERE transaction_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO transactions (account_id_from,account_id_to,amount,transaction_date) VALUES(?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM transactions WHERE transaction_id =?;";
    }

    @Override
    public ArrayList<Transaction> parsData(ResultSet rs) throws DAOexception {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        try {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("transaction_id"));
                transaction.setAccountIdFrom(rs.getInt("account_id_from"));
                transaction.setAccountIdTo(rs.getInt("account_id_to"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setTransactionsDate(convertToGregorianCalendar(rs.getDate("transaction_date")));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return transactions;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Transaction obj) throws DAOexception {
        try {
            prSt.setInt(1, obj.getAccountIdFrom());
            prSt.setInt(2, obj.getAccountIdTo());
            prSt.setDouble(3, obj.getAmount());
            prSt.setInt(4, obj.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Transaction obj) throws DAOexception {
        try {
            prSt.setInt(1, obj.getAccountIdFrom());
            prSt.setInt(2, obj.getAccountIdTo());
            prSt.setDouble(3, obj.getAmount());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}
