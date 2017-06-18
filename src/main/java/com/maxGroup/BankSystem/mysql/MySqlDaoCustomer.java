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

        try {
            while (rs.next()) {
                MySqlDaoCustomer.ExtendCustomer customer = new MySqlDaoCustomer.ExtendCustomer();
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("customer_name"));
                customer.setSurname(rs.getString("customer_surname"));
                customer.setBorn(convertToGregorianCalendar(rs.getDate("customer_born_date")));
                customer.setAddress(rs.getString("customer_address"));
                customer.setStatusCustomer(rs.getString("customer_status"));
                customer.setManagerId(rs.getInt("manager_id"));
                customers.add(customer);
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
