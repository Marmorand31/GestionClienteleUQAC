package com.architecture.project.customersCRUD;

// Placeholder à modifier quand nécessaire

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.*;
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

        JButton updateButton = new JButton("Modifier un client");
        updateButton.setBounds(250,100,180,30);
        panelCustomerDisplay.add(updateButton);

        JTextField updateTextField = new JTextField("");
        updateTextField.setBounds(440,100,30,30);
        panelCustomerDisplay.add(updateTextField);

        JButton delButton = new JButton("Supprimer un client");
        delButton.setBounds(510,100,180,30);
        panelCustomerDisplay.add(delButton);

        JTextField delTextField = new JTextField("");
        delTextField.setBounds(700,100,30,30);
        panelCustomerDisplay.add(delTextField);

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(180,140, 450, 25);
        errorLabel.setForeground(Color.red);
        panelCustomerDisplay.add(errorLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.CustomerCRUD("creation");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String updateIdText = updateTextField.getText();
                MainApplication.updateId = 0;
                if (updateIdText == null || updateIdText.isBlank()) {
                    errorLabel.setText("L'identifiant ne doit pas être vide.");
                } else {
                    try {
                        int updateIdInt = Integer.parseInt(updateIdText);

                        MainApplication.updateId = updateIdInt;
                        MainApplication.accueil.CustomerCRUD("update");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        errorLabel.setText("L'identifiant doit être un nombre entier.");
                    }
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String deleteIdText = delTextField.getText();
                if (deleteIdText == null || deleteIdText.isBlank()) {
                    errorLabel.setText("L'identifiant ne doit pas être vide.");
                } else {
                    try {
                        int deleteIdInt = Integer.parseInt(deleteIdText);

                        MainApplication.controllerCustomer.DeleteCustomer(deleteIdInt);
                        MainApplication.accueil.CustomerCRUD("display");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        errorLabel.setText("L'identifiant doit être un nombre entier.");
                    }
                }
            }
        });

        Object[][] data = MainApplication.controllerCustomer.selectAll();

        String[] columns = new String[]{"Id", "Surname", "Name", "Age"};

        JTable table = new JTable(data,columns);
        table.setFillsViewportHeight(true);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(50,170,700,350);
        panelCustomerDisplay.add(js);

        return panelCustomerDisplay;
    }
}
