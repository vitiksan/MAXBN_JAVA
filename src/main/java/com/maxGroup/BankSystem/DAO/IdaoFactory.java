package com.maxGroup.BankSystem.DAO;

public interface IdaoFactory<T> {

    public interface DaoCreator<T>{
        public IGenDao create(T connection);
    }

    public T getConnection() throws DAOexception;
    public IGenDao getDAO(T connection, Class daoClass) throws DAOexception;
}
