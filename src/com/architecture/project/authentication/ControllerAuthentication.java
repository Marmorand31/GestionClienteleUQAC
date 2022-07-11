package com.architecture.project.authentication;

import com.architecture.project.MainApplication;
import java.sql.*;

public class ControllerAuthentication {

    public Boolean Authentication(String login, String password) {
        String sql = "SELECT * FROM User WHERE LOGIN = '"+ login +"' AND PASSWORD = '"+ password +"'";
        try {
            Statement stmt = MainApplication.bddUserConn.createStatement();
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
            MainApplication.accueil.Login();
            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Authentication failed...");
        return false;
    }

    public void disconnect(){
        MainApplication.loggedIn = false;
        MainApplication.adminRole = false;
        System.out.println("disconnected successfully");
    }

}
