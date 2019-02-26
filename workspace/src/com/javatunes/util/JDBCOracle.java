package com.javatunes.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracle {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //jdbc:oracle:thin:@//ИМЯ_СЕРВЕРА:ПОРТ/ИМЯ_СЕРВИСА
        conn = DriverManager.getConnection("jdbc:oracle:thin://localhost:1527/JavaTunesDB");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getUserName());
        conn.close();

    }
}
