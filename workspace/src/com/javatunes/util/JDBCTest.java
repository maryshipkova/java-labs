package com.javatunes.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getUserName());


        //TODO:1-h

        ItemDAO itemDAO = new ItemDAO(conn);
        MusicItem musicItem1 =  itemDAO.searchById(1L);
        MusicItem musicItem2 =  itemDAO.searchById(100L);
        System.out.println(musicItem1);
        System.out.println(musicItem2);
        conn.close();
    }
}
