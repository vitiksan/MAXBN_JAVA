package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.DAO.AbstractDao;
import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.domain.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlDaoManager extends AbstractDao<Manager, Integer> {

    private class ExtendManager extends Manager {
        @Override
        protected void setId(int id) {
            super.setId(id);
        }
    }

    public MySqlDaoManager(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM managers;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE managers SET name=?,surname=?,post=?,salary=? WHERE manager_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO managers (name,surname,post,salary) VALUES(?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM managers WHERE manager_id =?;";
    }

    @Override
    public ArrayList<Manager> parsData(ResultSet rs) throws DAOexception, SQLException {
        ArrayList<Manager> managers = new ArrayList<Manager>();

        try {
            while (rs.next()) {
                ExtendManager manager = new ExtendManager();
                manager.setId(rs.getInt("manager_id"));
                manager.setName(rs.getString("name"));
                manager.setSurname(rs.getString("surname"));
                manager.setPost(rs.getString("post"));
                manager.setSalary(rs.getDouble("salary"));
                managers.add(manager);
            }
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return managers;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Manager obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setString(3, obj.getPost());
            prSt.setDouble(4, obj.getSalary());
            prSt.setInt(5, obj.getId());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Manager obj) throws DAOexception {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setString(3, obj.getPost());
            prSt.setDouble(4, obj.getSalary());
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}
