package com.architecture.project.clientsCRUD;

import com.architecture.project.MainApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class ControllerCustomer {

    public Object[][] selectAll() {
        String sql = "SELECT * FROM Customers";
        int size = numberOfCustomers();
        Object[][] data = new Object[size][4];

        try {
            Statement stmt = MainApplication.bddCustomerConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int iter = 0;
            while (rs.next()) {
                data[iter][0] = rs.getInt("id");
                data[iter][1] = rs.getString("surname");
                data[iter][2] = rs.getString("name");
                data[iter][3] = rs.getInt("age");
                iter++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public int numberOfCustomers() {
        int size = 0;
        String sql = "SELECT COUNT(*) AS total FROM Customers";

        try {
            Statement stmt = MainApplication.bddCustomerConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                size = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return size;
    }

    public List<Object> CreateCustomer(String surname, String name, String age) {
        Boolean success = false;
        String errorMessage = "Une erreur inconnue est survenue.";

        if (surname == null || surname.isBlank()) {
            errorMessage = "Le nom ne doit pas être vide.";
        } else if (name == null || name.isBlank()) {
            errorMessage = "Le prénom ne doit pas être vide.";
        } else if (age == null || age.isBlank()) {
            errorMessage = "L'age ne doit pas être vide.";
        } else {
            try {
                int ageInt = Integer.parseInt(age);
                String sql = "INSERT INTO Customers (SURNAME,NAME,AGE) VALUES ('" + surname + "','" + name + "'," + ageInt +")";

                try {
                    Statement stmt = MainApplication.bddCustomerConn.createStatement();
                    stmt.executeUpdate(sql);

                    success = true;
                    errorMessage = "";

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                errorMessage = "L'age doit être un nombre entier.";
            }
        }

        return Arrays.asList(success, errorMessage);
    }
    public void DeleteUser(int id){
        String sql = "DELETE FROM Customers WHERE ID = " + id;
        System.out.println(sql);

        try {
            Statement stmt = MainApplication.bddCustomerConn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
