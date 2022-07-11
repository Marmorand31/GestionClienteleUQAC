package com.architecture.project.clientsCRUD;

import com.architecture.project.MainApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
