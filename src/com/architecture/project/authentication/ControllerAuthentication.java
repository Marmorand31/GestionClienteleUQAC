package com.architecture.project.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    // TODO : Authentication, check (login, password) values // CREATE A LOGIN COLUMN IN DATABASE



}
