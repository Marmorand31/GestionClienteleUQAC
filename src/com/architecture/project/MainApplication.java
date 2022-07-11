package com.architecture.project;


import com.architecture.project.authentication.ControllerAuthentication;
import com.architecture.project.usersCRUD.ControllerUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainApplication {
    public static boolean loggedIn = false;
    public static boolean adminRole = false;
    public static Accueil accueil;
    public static ControllerAuthentication controllerAuthentication;
    public static ControllerUser controllerUser;
    public static Connection bddUserConn;

    public static void main(String[] args) {

        System.out.println("Welcome in a functioning project !!! :)");

        // Databases connection
        bddUserConn = connectUser();

        controllerAuthentication = new ControllerAuthentication();
        controllerUser = new ControllerUser();
        accueil = new Accueil();
        // Test database connection
//        Select CustomerTableSelect = new Select("Customers");
//        CustomerTableSelect.selectAll();

    }

    private static Connection connectUser() {
        String bddUserUrl = "jdbc:sqlite:C:/sqlite/BDDUser.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(bddUserUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
