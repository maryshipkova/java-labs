package com.javatunes.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Class.forName(org.apache.derby.jdbc.ClientDriver);
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getUserName());
        conn.close();

        //TODO:1-h

    }
}
