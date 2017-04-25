package com.maxGroup.BankSystem.DAO;

public class DAOexception extends Exception{

    public DAOexception(){

    }

    public DAOexception(String message) {
        super(message);
    }

    public DAOexception(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOexception(Throwable cause) {
        super(cause);
    }

    protected DAOexception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
