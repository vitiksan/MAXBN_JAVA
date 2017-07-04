package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Account;
import com.maxGroup.BankSystem.domain.Customer;
import com.maxGroup.BankSystem.domain.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class MySqlDaoCustomer extends AbstractDao<Customer,Integer> {

    private class ExtendCustomer extends Customer{
        public ExtendCustomer() {
            super();
        }

        public ExtendCustomer(int managerId) {
            super(managerId);
        }

        @Override
        protected void setManagerId(int managerId) {
            super.setManagerId(managerId);
        }

        @Override
        protected void setId(int idCustomer) {
            super.setId(idCustomer);
        }
    }

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

        @Override
        protected void setCustomerId(int customerId) {
            super.setCustomerId(customerId);
        }
    }

    public MySqlDaoCustomer(Connection connection) {
        super(connection);
    }


    //TODO 29.01 - Add JOIN
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM customers c JOIN accounts a USING(customer_id) JOIN transactions t " +
                "ON (t.account_id_from=a.account_id OR t.account_id_to=a.account_id) WHERE customer_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM customers c JOIN accounts a USING(customer_id) JOIN transactions t " +
                "ON (t.account_id_from=a.account_id OR t.account_id_to=a.account_id);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE customers SET customer_name=?,customer_surname=?,customer_born_date=?," +
                "customer_address,customer_status=?,manager_id=? WHERE customer_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO customers (customer_name,customer_surname,customer_born_date," +
                "customer_address,customer_status,manager_id,customer_registration_date) VALUES(?,?,?,?,?,?,?,(NOW()));";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM customers WHERE customer_id=?;";
    }

    @Override
    public ArrayList<Customer> parsData(ResultSet rs) throws DAOexception, SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        HashSet<ExtendAccount> accounts = new HashSet<>();
        boolean isAccount = false;
        boolean isCustomer = false;
        try {
            while (rs.next()) {
                MySqlDaoCustomer.ExtendCustomer customer = new MySqlDaoCustomer.ExtendCustomer();
                ExtendAccount account = new ExtendAccount();
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("transaction_is"));
                transaction.setAccountIdFrom(rs.getInt("account_id_from"));
                transaction.setAccountIdTo(rs.getInt("account_id_to"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setTransactionsDate(convertToGregorianCalendar(rs.getDate("transaction_date")));
                account.setId(rs.getInt("account_id"));
                account.setType(rs.getString("account_type"));
                account.setCardNumber(rs.getString("account_card_number"));
                account.setBalance(rs.getDouble("account_balance"));
                account.setPass(rs.getInt("account_password"));
                account.setExpCard(convertToGregorianCalendar(rs.getDate("account_validity")));
                for (ExtendAccount account1: accounts){
                    if (account.getId()==account1.getId()){
                        account1.addTransaction(transaction);
                    }
                }
                if (!isAccount){
                    account.addTransaction(transaction);
                    accounts.add(account);
                }
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("customer_name"));
                customer.setSurname(rs.getString("customer_surname"));
                customer.setBorn(convertToGregorianCalendar(rs.getDate("customer_born_date")));
                customer.setAddress(rs.getString("customer_address"));
                customer.setStatusCustomer(rs.getString("customer_status"));
                customer.setManagerId(rs.getInt("manager_id"));
                for (Customer customer1:customers){
                    if (customer1.getId()==customer.getId()){
                        customer1.getAccounts().addAll(accounts);
                    }
                }
                if (!isCustomer){
                    customer.getAccounts().addAll(accounts);
                    customers.add(customer);
                }
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return customers;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Customer obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBorn()));
            prSt.setString(4,obj.getAddress());
            prSt.setString(5, obj.getStatusCustomer());
            prSt.setInt(6, obj.getManagerId());
            prSt.setInt(7, obj.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Customer obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBorn()));
            prSt.setString(4,obj.getAddress());
            prSt.setString(5, obj.getStatusCustomer());
            prSt.setInt(6, obj.getManagerId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}
