package com.architecture.project.usersCRUD;

import java.sql.*;

public class ControllerUser {

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/BDDUser.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Object[][] selectAll() {
        String sql = "SELECT * FROM User";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int size = numberofUsers();
        Object[][] data = new Object[size][5];

        try {
            conn = this.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            int iter = 0;
            while (rs.next()) {
                data[iter][0] = rs.getInt("id");
                data[iter][1] = rs.getString("surname");
                data[iter][2] = rs.getString("name");
                data[iter][3] = rs.getInt("admin");
                data[iter][4] = rs.getString("password");
                iter++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { rs.close(); } catch (Exception e) { /* Ignored */ }
            try { stmt.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
        return data;
    }

    public int numberofUsers(){
        int size = 0;
        String sql = "SELECT COUNT(*) AS total FROM User";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                size = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { rs.close(); } catch (Exception e) { /* Ignored */ }
            try { stmt.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }

        return size;
    }
}
