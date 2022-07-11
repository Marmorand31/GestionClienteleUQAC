package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class ControllerUser {

    public Object[][] selectAll() {
        String sql = "SELECT * FROM User";
        int size = numberofUsers();
        Object[][] data = new Object[size][6];

        try {
            Statement stmt = MainApplication.bddUserConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int iter = 0;
            while (rs.next()) {
                data[iter][0] = rs.getInt("id");
                data[iter][1] = rs.getString("surname");
                data[iter][2] = rs.getString("name");
                data[iter][3] = rs.getInt("admin");
                data[iter][4] = rs.getString("password");
                data[iter][5] = rs.getString("login");
                iter++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public int numberofUsers() {
        int size = 0;
        String sql = "SELECT COUNT(*) AS total FROM User";

        try {
            Statement stmt = MainApplication.bddUserConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                size = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return size;
    }

    public List<Object> CreateUser(String surname, String name, Boolean admin, String login, String pwd, String pwdConfirm) {
        Boolean success = false;
        String errorMessage = "Une erreur inconnue est survenue.";

        if (surname == null || surname.isBlank()) {
            errorMessage = "Le nom ne doit pas être vide.";
        } else if (name == null || name.isBlank()) {
            errorMessage = "Le prénom ne doit pas être vide.";
        } else if (login == null || login.isBlank()) {
            errorMessage = "L'identifiant ne doit pas être vide.";
        } else if (pwd == null || pwd.isBlank()) {
            errorMessage = "Le mot de passe ne doit pas être vide.";
        } else if (pwdConfirm == null || pwdConfirm.isBlank()) {
            errorMessage = "La confirmation du mot de passe ne doit pas être vide.";
        } else if (!pwd.equals(pwdConfirm)) {
            errorMessage = "Le mot de passe et la confirmation du mot de passe doivent être identiques.";
        } else {
            int adminInt = admin ? 1 : 0;
            String sql = "INSERT INTO User (SURNAME,NAME,ADMIN,LOGIN,PASSWORD) VALUES ('" + surname + "','" + name + "'," + adminInt
                    + ",'" + login + "','" + pwd + "')";

            try {
                Statement stmt = MainApplication.bddUserConn.createStatement();
                stmt.executeUpdate(sql);

                success = true;
                errorMessage = "";

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return Arrays.asList(success, errorMessage);
    }
}