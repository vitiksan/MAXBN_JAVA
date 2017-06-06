package com.maxGroup.BankSystem.DAO;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class AbstractDao<T extends Identificator<PK>, PK extends Serializable> implements IGenDao<T, PK> {
    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract String getSelectAllQuery();

    public abstract String getUpdateQuery();

    public abstract String getCreateQuery();

    public abstract String getDeleteQuery();

    public abstract ArrayList<T> parsData(ResultSet rs) throws DAOexception, SQLException;

    public abstract void parsUpdate(PreparedStatement prSt, T obj,int key) throws DAOexception;

    public abstract void parsInsert(PreparedStatement prSt, T obj,int key) throws DAOexception;

    @Override
    public T createEx(T obj,int key) throws DAOexception {
        T temp;
        String query = getCreateQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            parsInsert(prSt, obj,key);
            int count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Created more then 1 object " + count);
        } catch (Exception e) {
            throw new DAOexception(e);
        }


        query = getSelectQuery() + "(SELECT last_insert_id());";

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            ResultSet rs = prSt.executeQuery();
            ArrayList<T> someList = parsData(rs);

            if (someList == null || someList.size() !=1)
                throw new DAOexception("Error with search created object by id");
            temp = someList.iterator().next();
        } catch (Exception e) {
            throw new DAOexception(e);
        }


        return temp;
    }

    @Override
    public T read(int id) throws DAOexception {
        ArrayList<T> someList;
        String query = getSelectQuery() + "?;";

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            prSt.setInt(1, id);
            ResultSet rs = prSt.executeQuery();
            someList = parsData(rs);
        } catch (Exception e) {
            throw new DAOexception(e);
        }

        if (someList == null || someList.size() == 0) return null;

        if (someList.size() > 1) {
            throw new DAOexception("Отримано забато даних");
        }

        return someList.iterator().next();
    }

    @Override
    public ArrayList<T> readAll() throws DAOexception {
        ArrayList<T> someList;
        String query = getSelectAllQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            ResultSet resultSet = prSt.executeQuery();
            someList = parsData(resultSet);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return someList;
    }

    @Override
    public boolean update(T obj,int key) throws DAOexception {
        String query = getUpdateQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            parsUpdate(prSt, obj,key);
            int count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Modified more then 1 field " + count);
            else return true;
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    @Override
    public boolean delete(T obj) throws DAOexception {
        String query = getDeleteQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            try {
                prSt.setObject(1, obj.getId());
            } catch (Exception e) {
                throw new DAOexception(e);
            }

            int count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Deleted more then 1 field " + count);
            else return true;
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }

    protected java.util.GregorianCalendar convertToGregorianCalendar(java.sql.Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    protected java.sql.Date convertToSqlDate(java.util.GregorianCalendar gregorianCalendar) {
        return new java.sql.Date(gregorianCalendar.getTime().getTime());
    }
}
