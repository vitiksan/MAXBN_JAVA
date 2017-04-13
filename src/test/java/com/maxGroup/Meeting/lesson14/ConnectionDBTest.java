package com.maxGroup.Meeting.lesson14;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionDBTest {
    @Test
    public void getConnection() throws Exception {
        ConnectionDB.createManager();
        //ConnectionDB.getUserFromDB();
    }

}