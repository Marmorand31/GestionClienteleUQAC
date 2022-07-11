package com.architecture.project.clientsCRUD;

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCustomerCreation {
    public JPanel display() {
        JPanel panelCustomerCreation = new JPanel();
        panelCustomerCreation.setLayout(null);

        JLabel headerLabel = new JLabel("Création d'un nouveau client");
        headerLabel.setBounds(330,40,180,40);
        panelCustomerCreation.add(headerLabel);

        JLabel surnameLabel = new JLabel("Nom");
        surnameLabel.setBounds(320,180, 70, 25);
        panelCustomerCreation.add(surnameLabel);
        JTextField surnameField = new JTextField();
        surnameField.setBounds(390,180, 100, 25);
        panelCustomerCreation.add(surnameField);

        JLabel nameLabel = new JLabel("Prénom");
        nameLabel.setBounds(320,220, 100, 25);
        panelCustomerCreation.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(390,220, 100, 25);
        panelCustomerCreation.add(nameField);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(350,260, 100, 25);
        panelCustomerCreation.add(ageLabel);
        JTextField ageField = new JTextField();
        ageField.setBounds(390,260, 100, 25);
        panelCustomerCreation.add(ageField);

        JButton backButton = new JButton("Annuler");
        backButton.setBounds(300, 330, 100, 25);
        panelCustomerCreation.add(backButton);

        JButton createButton = new JButton("Créer");
        createButton.setBounds(410, 330, 100, 25);
        panelCustomerCreation.add(createButton);

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(300,380, 450, 25);
        errorLabel.setForeground(Color.red);
        panelCustomerCreation.add(errorLabel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");
                surnameField.setText("");
                nameField.setText("");
                ageField.setText("");
                MainApplication.accueil.CustomerCRUD("display");
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");

                String surname = surnameField.getText();
                String name = nameField.getText();
                String age = ageField.getText();

                List<Object> answer= MainApplication.controllerCustomer.CreateCustomer(surname, name, age);
                Boolean success = (Boolean) answer.get(0);
                String errorMessage = (String) answer.get(1);

                if(success) {
                    MainApplication.accueil.CustomerCRUD("display");
                    surnameField.setText("");
                    nameField.setText("");
                    ageField.setText("");

                } else {
                    errorLabel.setText(errorMessage);
                }

            }
        });

        return panelCustomerCreation;
    }
}
