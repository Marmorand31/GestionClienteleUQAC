package com.architecture.project;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

    // Database classic connection (got to place sqlite.db at the same location)
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/sqlite/sqlite.db";
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
        String sql = "SELECT * FROM Customers";

        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set to display
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("surname") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age"));
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
