package com.maxGroup.BankSystem.DAO;

import com.maxGroup.BankSystem.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDAO {
    Manager create();
    Manager read(int id) throws SQLException;
    void update(Manager manager);
    void delete(int id);
    List<Manager> getAll();
}
