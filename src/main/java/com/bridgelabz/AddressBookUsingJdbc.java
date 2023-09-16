package com.bridgelabz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookUsingJdbc {
    public static int getDataFromTable(Statement stmt){
        int totalRowCount = 0;
        String displayTable = "SELECT * FROM address_book";
        try {
            ResultSet rs = stmt.executeQuery(displayTable);
            while (rs.next()) {
                totalRowCount++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return totalRowCount;
    }
}