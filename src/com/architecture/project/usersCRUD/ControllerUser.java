package com.architecture.project.usersCRUD;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class ControllerUser {

    String bddUrl;

    public ControllerUser() { this.bddUrl = "jdbc:sqlite:C:/sqlite/BDDUser.db"; }

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

    public List<Object> CreateUser(String surname, String name, Boolean admin, String login, String pwd, String pwdConfirm) {
        Boolean success = false;
        String errorMessage = "Une erreur inconnue est survenue.";

        if(surname == null || surname.isBlank()) {
            errorMessage = "Le nom ne doit pas être vide.";
            return Arrays.asList(success, errorMessage);
        }if(name == null || name.isBlank()) {
            errorMessage = "Le prénom ne doit pas être vide.";
            return Arrays.asList(success, errorMessage);
        }if(login == null || login.isBlank()) {
            errorMessage = "L'identifiant ne doit pas être vide.";
            return Arrays.asList(success, errorMessage);
        }if(pwd == null || pwd.isBlank()) {
            errorMessage = "Le mot de passe ne doit pas être vide.";
            return Arrays.asList(success, errorMessage);
        }if(pwdConfirm == null || pwdConfirm.isBlank()) {
            errorMessage = "La confirmation du mot de passe ne doit pas être vide.";
            return Arrays.asList(success, errorMessage);
        }

        if(!pwd.equals(pwdConfirm)) {
            errorMessage = "Le mot de passe et la confirmation du mot de passe doivent être identiques.";
            return Arrays.asList(success, errorMessage);
        }

        int adminInt = admin ? 1 : 0;
        String sql = "INSERT INTO User (SURNAME,NAME,ADMIN,LOGIN,PASSWORD) VALUES ('"+surname+"','"+name+"',"+adminInt
                +",'"+login+"','"+pwd+"')";
        System.out.println(sql);

        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            success = true;
            errorMessage = "";
            return Arrays.asList(success, errorMessage);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Arrays.asList(success, errorMessage);
    }

}
