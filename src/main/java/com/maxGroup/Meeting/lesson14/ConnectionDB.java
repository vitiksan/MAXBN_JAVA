package com.maxGroup.Meeting.lesson14;

import org.apache.log4j.Logger;

import java.sql.*;

public class ConnectionDB {
    private static String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/banksystem?useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static final Logger log = Logger.getLogger(ConnectionDB.class);

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


}
