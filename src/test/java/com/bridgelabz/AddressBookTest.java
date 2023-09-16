package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookTest {
    static final String DB_URL = "jdbc:mysql://localhost:3306/address_book_service_db";
    static final String USER = "root";
    static final String PASS = "root";

    @Test
    public void givenRetrieveQueryShouldReturnTotalRowsCount(){
        Connection conn = null;
        Statement stmt = null;
        int totalRowsCount = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            totalRowsCount = AddressBookUsingJdbc.getDataFromTable(stmt);
        }catch (SQLException e){
            System.out.println(e);
        }
        Assert.assertEquals(6,totalRowsCount);
    }
}