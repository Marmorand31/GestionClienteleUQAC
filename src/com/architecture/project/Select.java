package com.architecture.project;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    // Database classic connection (got to place sqlite.db at the same location)
    String bdd;

    public Select(String bdd) {
        this.bdd = bdd;
    }

    private Connection connect() {
        // SQLite connection string
        String url = "";
        if (bdd.equals("User")) {
            url = "jdbc:sqlite:C:/sqlite/BDDUser.db";
        } else if (bdd.equals("Customers")) {
            url = "jdbc:sqlite:C:/sqlite/BDDCustomers.db";
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Select all elements from Customers table
    public void selectAll() {
        String sql = "";
        if (bdd.equals("User")) {
            sql = "SELECT * FROM User";
        } else if (bdd.equals("Customers")) {
            sql = "SELECT * FROM Customers";
        }
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set to display
            if (bdd.equals("User")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("surname") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("Admin") + "\t" +
                            rs.getString("name"));
                }
            } else if (bdd.equals("Customers")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("surname") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("age"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
