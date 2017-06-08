package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlDaoCustomer extends AbstractDao<Customer,Integer> {

    private class ExtendCustomer extends Customer{
        @Override
        protected void setId(int idCustomer) {
            super.setId(idCustomer);
        }
    }

    public MySqlDaoCustomer(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM customers WHERE customer_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM customers;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE customers SET customer_name=?,customer_surname=?,born_date=?," +
                "address,customer_status=? WHERE customer_id=? AND manager_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO customers (customer_name,customer_surname,born_date," +
                "address,customer_status,manager_id,create_date) VALUES(?,?,?,?,?,?,(NOW()));";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM customers WHERE customer_id =?;";
    }

    @Override
    public ArrayList<Customer> parsData(ResultSet rs) throws DAOexception, SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try {
            while (rs.next()) {
                MySqlDaoCustomer.ExtendCustomer customer = new MySqlDaoCustomer.ExtendCustomer();
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("customer_name"));
                customer.setSurname(rs.getString("customer_surname"));
                customer.setBorn(convertToGregorianCalendar(rs.getDate("born_date")));
                customer.setStatusCustomer(rs.getString("customer_status"));
                customers.add(customer);
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return customers;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Customer obj, int key) throws DAOexception {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBorn()));
            prSt.setString(4,obj.getAddres());
            prSt.setString(5, obj.getStatusCustomer());
            prSt.setInt(6, obj.getId());
            prSt.setObject(7,key);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Customer obj,int key) throws DAOexception {
        try {

            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, convertToSqlDate(obj.getBorn()));
            prSt.setString(4,obj.getAddres());
            prSt.setString(5, obj.getStatusCustomer());
            prSt.setInt(6,key);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}