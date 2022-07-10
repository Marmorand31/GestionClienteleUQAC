package com.architecture.project.usersCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsersCrudController {

    String bddUrl;

    public UsersCrudController() { this.bddUrl = "jdbc:sqlite:C:/sqlite/BDDUser.db"; }

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
