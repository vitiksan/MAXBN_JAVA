package com.maxGroup.Meeting.lesson14;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Scanner;

public class ConnectionDB {
    private static String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua/servlab_devmax?useSSL=false";
    private static String USERNAME = "servlab_devmax";
    private static String PASSWORD = "f843xa4x";


    private static final Logger log = Logger.getLogger(ConnectionDB.class);
    private static final String INSERT_NEW = "INSERT INTO managers " +
            "(id,name,surname,post,salary) " +
            "VALUES (?,?,?,?,?)";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVERNAME);
            log.info("Драйвер JDBC отримано");
        } catch (ClassNotFoundException e) {
            log.error("Драйвер JDBC не завантажено");
            log.error(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("Успішне підключення до БД");
        } catch (SQLException e) {
            log.error("Не вдалося підключитися до БД");
            log.error(e.getMessage());
        }

        return connection;
    }

    public static void createManager() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String query = "INSERT INTO managers " +
                "(id,name,surname,post,salary) " +
                "VALUES (5,'Olia','Stfn','manager',15000)";

        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            log.error("Не вдалося створити нового менеджера");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }

    }

    public static void createManagerPS() throws SQLException {
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = getConnection();
            prSt = connection.prepareStatement(INSERT_NEW);
            prSt.setInt(1, 1);
            prSt.setString(2, "Nazar");
            prSt.setString(3, "Mykhailiv");
            prSt.setString(4, "Mentor");
            prSt.setDouble(5, 5000000.0);

            prSt.execute();

        } catch (SQLException e) {
            log.error("Не вдалося створити нового менеджера");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prSt != null) prSt.close();
        }

    }

    public static void createManagerBT() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String query = "INSERT INTO managers " +
                "(id,name,surname,post,salary) " +
                "VALUES (5,'Olia','Stfn','manager',15000)";

        try {
            connection = getConnection();
            statement = connection.createStatement();

            statement.addBatch("INSERT INTO managers (id,name,surname,post,salary) " +
                    "VALUES (5,'Olia','Stfn','manager',15000)");

            statement.addBatch("INSERT INTO managers (id,name,surname,post,salary) " +
                    "VALUES (6,'Vila','Stfn','manager',15000)");

            statement.executeBatch();
            statement.clearBatch();

        } catch (SQLException e) {
            log.error("Не вдалося створити нового менеджера");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }

    }

    public static void getUserFromDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String query = "SELECT * FROM managers";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String post = resultSet.getString("post");
                double salary = resultSet.getDouble("salary");
                System.out.println(id + "\t" + name + "\t" + surname + "\t" + post + "\t" + salary);
            }


        } catch (SQLException e) {
            log.error("Не вдалося отримати дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }

    public static void updateSalaryForManagers() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String query = "UPDATE managers SET salary=5000 WHERE id=1;";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);


        } catch (SQLException e) {
            log.error("Не вдалося змінити дані");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }

    public static void deleteLineFromDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String query = "DELETE FROM managers WHERE id=5;";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(query);


        } catch (SQLException e) {
            log.error("Не вдалося видалити людину");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }

}
