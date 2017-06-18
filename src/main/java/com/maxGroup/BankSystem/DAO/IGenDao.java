package com.maxGroup.BankSystem.DAO;

import java.io.Serializable;
import java.util.ArrayList;

public interface IGenDao<T, PK extends Serializable> {

    T createEx(T obj) throws DAOexception;

    T read(int key) throws DAOexception;

    ArrayList<T> readAll() throws DAOexception;

    boolean update(T obj) throws DAOexception;

    boolean delete(T obj) throws DAOexception;
}
