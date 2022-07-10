package com.architecture.project.authentication;

import com.architecture.project.MainApplication;

import java.sql.*;

public class ControllerAuthentication {
    String bddUrl;

    public ControllerAuthentication() { this.bddUrl = "jdbc:sqlite:C:/sqlite/BDDUser.db"; }

    // Database connection
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.bddUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public Boolean Authentication(String login, String password) {
        String sql = "SELECT * FROM User WHERE LOGIN = '"+ login +"' AND PASSWORD = '"+ password +"'";

        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.next()) {   // No result found
                System.out.println("Authentication failed...");
                return false;
            }

            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("login") + "\t" +
                    rs.getString("password") + "\t" +
                    rs.getInt("admin"));

            System.out.println("Authentication success ... wait ...");

            MainApplication.loggedIn = true;
            MainApplication.adminRole = rs.getInt("admin") == 1;

            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Authentication failed...");
        return false;
    }


    // TODO : LOG OUT, reset MainApplication variables loggedIn and adminRole to default values, false and false
    // public void LogOut() {}


}