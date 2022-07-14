package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewUserDisplay {

    public JPanel display() {
        JPanel panelUserDisplay = new JPanel();
        panelUserDisplay.setLayout(null);

        JButton homeButton = new JButton("Retour Accueil");
        homeButton.setBounds(10,10,130,30);
        panelUserDisplay.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.BackHome();
            }
        });

        JLabel headerLabel = new JLabel("Gestion des utilisateurs");
        headerLabel.setBounds(330,40,180,40);
        panelUserDisplay.add(headerLabel);

        JButton addButton = new JButton("Nouvel utilisateur");
        addButton.setBounds(30,100,180,30);
        panelUserDisplay.add(addButton);

        JButton updateButton = new JButton("Modifier un utilisateur");
        updateButton.setBounds(250,100,180,30);
        panelUserDisplay.add(updateButton);

        JTextField updateTextField = new JTextField("");
        updateTextField.setBounds(440,100,30,30);
        panelUserDisplay.add(updateTextField);

        JButton delButton = new JButton("Supprimer un utilisateur");
        delButton.setBounds(510,100,180,30);
        panelUserDisplay.add(delButton);

        JTextField delTextField = new JTextField("");
        delTextField.setBounds(700,100,30,30);
        panelUserDisplay.add(delTextField);

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(180,140, 450, 25);
        errorLabel.setForeground(Color.red);
        panelUserDisplay.add(errorLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.UserCRUD("creation");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String updateIdText = updateTextField.getText();
                if (updateIdText == null || updateIdText.isBlank()) {
                    errorLabel.setText("L'identifiant ne doit pas être vide.");
                } else {
                    try {
                        int updateIdInt = Integer.parseInt(updateIdText);

                        MainApplication.updateId = updateIdInt;
                        MainApplication.accueil.UserCRUD("update");
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
                MainApplication.controllerUser.DeleteUser(Integer.valueOf(delTextField.getText()));
                MainApplication.accueil.UserCRUD("display");
            }
        });

        Object[][] data = MainApplication.controllerUser.selectAll();

        String[] columns = new String[]{"Id", "Surname", "Name", "Admin", "Password", "Login"};

        JTable table = new JTable(data,columns);
        table.setFillsViewportHeight(true);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(50,170,700,350);
        panelUserDisplay.add(js);

        return panelUserDisplay;
    }
}

