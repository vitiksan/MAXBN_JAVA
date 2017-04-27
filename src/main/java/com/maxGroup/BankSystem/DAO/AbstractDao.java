package com.maxGroup.BankSystem.DAO;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenDao<T, PK> {
    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract List<T> parsData(ResultSet rs);


    public T read(int id) throws DAOexception {
        List<T> someList;
        String query = getSelectQuery() + "WHERE id = ?";

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            prSt.setInt(1, id);
            ResultSet rs = prSt.executeQuery();
            someList = parsData(rs);
        } catch (Exception e) {
            throw  new DAOexception(e);
        }

        if (someList == null || someList.size() == 0) return null;

        if (someList.size() > 1) {
            throw  new DAOexception("Отримано забато даних");
        }

        return someList.iterator().next();
    }
}
