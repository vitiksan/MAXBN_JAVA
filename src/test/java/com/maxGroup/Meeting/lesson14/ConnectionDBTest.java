package com.maxGroup.Meeting.lesson14;

import static org.junit.Assert.*;
import org.junit.Test;


public class ConnectionDBTest {
    @Test
    public void createManagerPS() throws Exception {
        //ConnectionDB.createManagerPS();
        ConnectionDB.createManagerBT(3);
    }

    @Test
    public void getConnection() throws Exception {
        //ConnectionDB.createManager();
        //ConnectionDB.getUserFromDB();
        //ConnectionDB.updateSalaryForManagers();
        ConnectionDB.deleteLineFromDB();
    }
}