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

    public static int getContactsByCity(Statement stmt){
        int contactsCount = 0;
        String getPersonFromCity = "select * from address_book where city = 'banglore'";
        try{
            ResultSet rs1 = stmt.executeQuery(getPersonFromCity);
            while (rs1.next()) {
                contactsCount++;
                // Retrieve by column name
                String firstName = rs1.getString("firstname");
                String lastName = rs1.getString("lastname");
                String address = rs1.getString("address");
                String city = rs1.getString("city");
                String state = rs1.getString("state");
                int zip = rs1.getInt("zip");
                String phoneNumber = rs1.getString("phoneNumber");
                String email = rs1.getString("email");

                // Display values
                System.out.println("first name: " + firstName);
                System.out.println("last name: " + lastName);
                System.out.println("address: " + address);
                System.out.println("city: " + city);
                System.out.println("state: " + state);
                System.out.println("zip: " + zip);
                System.out.println("phone number: " + phoneNumber);
                System.out.println("email: " + email);

                System.out.println("---------------------------");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return contactsCount;
    }
}