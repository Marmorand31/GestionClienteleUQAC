package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class ControllerUser {

    public List<Object> CreateUser(String surname, String name, Boolean admin, String login, String pwd, String pwdConfirm) {
        Boolean success = false;
        String errorMessage = "Une erreur inconnue est survenue.";

        if(surname == null || surname.isBlank()) {
            errorMessage = "Le nom ne doit pas être vide.";
        } else if(name == null || name.isBlank()) {
            errorMessage = "Le prénom ne doit pas être vide.";
        } else if(login == null || login.isBlank()) {
            errorMessage = "L'identifiant ne doit pas être vide.";
        } else if(pwd == null || pwd.isBlank()) {
            errorMessage = "Le mot de passe ne doit pas être vide.";
        } else if(pwdConfirm == null || pwdConfirm.isBlank()) {
            errorMessage = "La confirmation du mot de passe ne doit pas être vide.";
        }

        else if(!pwd.equals(pwdConfirm)) {
            errorMessage = "Le mot de passe et la confirmation du mot de passe doivent être identiques.";
        }

        else {
            int adminInt = admin ? 1 : 0;
            String sql = "INSERT INTO User (SURNAME,NAME,ADMIN,LOGIN,PASSWORD) VALUES ('"+surname+"','"+name+"',"+adminInt
                    +",'"+login+"','"+pwd+"')";

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
