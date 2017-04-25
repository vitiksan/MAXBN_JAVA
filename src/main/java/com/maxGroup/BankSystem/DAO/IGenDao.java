package com.maxGroup.BankSystem.DAO;

import java.io.Serializable;
import java.util.ArrayList;

public interface IGenDao<T, PK extends Serializable> {
    T create() throws DAOexception;

    T createEx(T obj) throws DAOexception;

    T read(int key) throws DAOexception;

    ArrayList<T> readAll() throws DAOexception;

    void update(T obj) throws DAOexception;

    void delete(T obj) throws DAOexception;
}
