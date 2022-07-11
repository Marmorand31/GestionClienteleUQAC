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
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

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
            MainApplication.accueil.Login();
            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try { rs.close(); } catch (Exception e) { /* Ignored */ }
            try { stmt.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }

        System.out.println("Authentication failed...");
        return false;
    }

    public void disconnect(){
        MainApplication.loggedIn = false;
        MainApplication.adminRole = false;
        System.out.println("disconnected successfully");
    }


    // TODO : LOG OUT, reset MainApplication variables loggedIn and adminRole to default values, false and false
    // public void LogOut() {}


}
