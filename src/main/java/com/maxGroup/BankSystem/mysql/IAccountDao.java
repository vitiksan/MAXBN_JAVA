package com.maxGroup.BankSystem.mysql;


import com.maxGroup.AccountFactory.*;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    void create(IAccount account) throws SQLException;
    IAccount read(int id) throws SQLException;
    void update(IAccount account) throws SQLException;
    void delete(int id) throws SQLException;
    List<IAccount> getAll() throws SQLException;
}
