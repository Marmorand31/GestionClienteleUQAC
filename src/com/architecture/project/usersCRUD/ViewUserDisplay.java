package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;
import com.architecture.project.authentication.ControllerAuthentication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class ViewUserDisplay {

    public JPanel display() {
        JPanel panelUserDisplay = new JPanel();
        panelUserDisplay.setBackground(Color.BLACK);
        Object[][] data = MainApplication.controllerUser.selectAll();

        String[] columns = new String[]{"Id", "Surname", "Name", "Admin", "Password"};

        JTable table = new JTable(data,columns);
        table.setFillsViewportHeight(true);
        panelUserDisplay.add(new JScrollPane(table));

        return panelUserDisplay;
    }
}

