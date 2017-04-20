package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.Manager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class MySQLManagerDAO implements IManagerDAO {
    private final Connection connection;
    private final String READ = "SELECT * FROM managers WHERE id = ?;";

    private static final Logger log = Logger.getLogger(MySQLManagerDAO.class);

    public MySQLManagerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Manager create() {
        return null;
    }

    @Override
    public Manager read(int id) throws SQLException {
        PreparedStatement prSt = null;
        Manager manager = new Manager();

        try {
            prSt = connection.prepareStatement(READ);
            prSt.setInt(1, id);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                //manager.set = resultSet.getInt("id");
                manager.setName(resultSet.getString("name"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setPost(resultSet.getString("post"));
                manager.setSalary(resultSet.getDouble("salary"));
            }


        } catch (SQLException e) {
            log.error("Не вдалося отримати дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }
        return manager;
    }

    @Override
    public void update(Manager manager) throws SQLException{

    }

    @Override
    public void delete(int id) throws SQLException{

    }

    @Override
    public List<Manager> getAll()throws SQLException {
        return null;
    }
}
