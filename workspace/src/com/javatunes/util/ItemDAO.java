/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ItemDAO {
    // connection to the database (assumed to be open)
    private Connection m_conn = null;

    //// PreparedStatement Lab ////
    //-- declare the PreparedStatement for searchByKeyword --//


    //// Update Lab ////
    //-- declare the PreparedStatement for create --//


    // constructor
    public ItemDAO(Connection conn)
            throws SQLException {
        // store the connection
        m_conn = conn;

        //// PreparedStatement Lab ////
        //-- define the ?-SQL for searchByKeyword --//


        //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//


        //// Update Lab ////
        //-- define the ?-SQL for create --//


        //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//

    }


    //// DAO Lab ////
    public MusicItem searchById(Long id)
            throws SQLException {
        // declare return value
        MusicItem result = null;

        // declare JDBC objects
        Statement stmt = null;

        //-- build the SQL statement --//
        String sql = "SELECT * FROM GUEST.ITEM WHERE ITEM_ID=" + id;

        try {
            //-- initialize the Statement object --//
            stmt = m_conn.createStatement();

            //-- execute the SQL statement, get a ResultSet back --//
            ResultSet rs = stmt.executeQuery(sql);

            //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
            //-- if ID not found, the return value remains null --//
            if (rs != null) {
                result = new MusicItem();
                JDBCUtilities.printResultSet(rs);
                System.out.println(rs.getLong("ITEM_ID"));
            }

        } finally {
            //-- close the Statement - this closes its ResultSet --//
            stmt.close();
        }

        // return the value object
        return result;
    }


    //// PreparedStaement Lab ////
    public Collection<MusicItem> searchByKeyword(String keyword)
            throws SQLException {
        // create storage for the results
        Collection<MusicItem> result = new ArrayList<MusicItem>();

        // create the %keyword% wildcard syntax used in SQL LIKE operator
        String wildcarded = "%" + keyword + "%";
        String sql = "SELECT * FROM GUEST.ITEM WHERE TITLE LIKE " + wildcarded;

        //-- set the ? parameters on the PreparedStatement --//
        PreparedStatement pstmt = m_conn.prepareStatement(sql);
        pstmt.setString(1, wildcarded);

        //-- execute the PreparedStatement, get a ResultSet back --//
        ResultSet rs = pstmt.executeQuery();

        //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
        //-- add the ItemValue to the Collection via Collection's add method --//
        while (rs.next()) {
            result.add(new MusicItem(rs.getLong("ITEM_ID")));
        }

        // return the Collection
        return result;
    }


    //// Update Lab ////
    public void create(MusicItem item)
            throws SQLException {
        // Use the following releaseDate value in the  prepared statement for setDate
        java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
        //-- set the ? parameters on the PreparedStatement --//
        String sql = "INSERT into GUEST.ITEM VALUES";

        PreparedStatement stmt = m_conn.prepareStatement(sql);
        stmt.setString(1, item.getTitle());
        stmt.setString(2, item.getArtist());
        stmt.setString(3, item.getReleaseDateString());
        stmt.setBigDecimal(4, item.getListPrice());
        stmt.setBigDecimal(5, item.getPrice());
        stmt.setInt(6, 1); // version

        //-- execute the PreparedStatement - ignore the update count --//
        System.out.println(stmt.executeUpdate());
        m_conn.commit();

    }


    //// PreparedStatement and Update Labs ////
    public void close() {

//        try {
//            //// PreparedStatement Lab ////
//            //-- close the PreparedStatement for searchByKeyword --//
//
//
//            //// Update Lab ////
//            //-- close the PreparedStatement for create --//
//
//        } catch (SQLException sqle) {
//            JDBCUtilities.printSQLException(sqle);
//        }

    }
}
