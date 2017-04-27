package com.maxGroup.BankSystem.mysql;

import com.maxGroup.BankSystem.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDao {
    void create(Manager manager) throws SQLException;
    Manager read(int id) throws SQLException;
    void update(Manager manager) throws SQLException;
    void delete(int id) throws SQLException;
    List<Manager> getAll() throws SQLException;
}
