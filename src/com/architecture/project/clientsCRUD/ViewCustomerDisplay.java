package com.architecture.project.clientsCRUD;

// Placeholder à modifier quand nécessaire

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomerDisplay {

    public JPanel display() {
        JPanel panelCustomerDisplay = new JPanel();
        panelCustomerDisplay.setLayout(null);

        JButton homeButton = new JButton("Retour Accueil");
        homeButton.setBounds(10,10,130,30);
        panelCustomerDisplay.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.BackHome();
            }
        });

        JLabel headerLabel = new JLabel("Gestion des clients");
        headerLabel.setBounds(330,40,180,40);
        panelCustomerDisplay.add(headerLabel);


        JButton addButton = new JButton("Nouveau client");
        addButton.setBounds(30,100,180,30);
        panelCustomerDisplay.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.CustomerCRUD("creation");
            }
        });

        Object[][] data = MainApplication.controllerCustomer.selectAll();

        String[] columns = new String[]{"Id", "Surname", "Name", "Age"};

        JTable table = new JTable(data,columns);
        table.setFillsViewportHeight(true);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(50,150,700,400);
        panelCustomerDisplay.add(js);

        return panelCustomerDisplay;
    }
}
