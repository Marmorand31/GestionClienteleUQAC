package com.architecture.project.customersCRUD;

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCustomerUpdate {

    public JPanel display() {
        JPanel panelCustomerUpdate = new JPanel();
        panelCustomerUpdate.setLayout(null);


        JLabel headerLabel = new JLabel("Modification d'un client");
        headerLabel.setBounds(330,40,180,40);
        panelCustomerUpdate.add(headerLabel);

        JLabel surnameLabel = new JLabel("Nom");
        surnameLabel.setBounds(320,180, 70, 25);
        panelCustomerUpdate.add(surnameLabel);
        JTextField surnameField = new JTextField();
        surnameField.setBounds(390,180, 100, 25);
        panelCustomerUpdate.add(surnameField);

        JLabel nameLabel = new JLabel("Prénom");
        nameLabel.setBounds(320,220, 100, 25);
        panelCustomerUpdate.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(390,220, 100, 25);
        panelCustomerUpdate.add(nameField);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(350,260, 100, 25);
        panelCustomerUpdate.add(ageLabel);
        JTextField ageField = new JTextField();
        ageField.setBounds(390,260, 100, 25);
        panelCustomerUpdate.add(ageField);

        JButton backButton = new JButton("Annuler");
        backButton.setBounds(300, 330, 100, 25);
        panelCustomerUpdate.add(backButton);

        JButton createButton = new JButton("Modifier");
        createButton.setBounds(410, 330, 100, 25);
        panelCustomerUpdate.add(createButton);

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(300,380, 450, 25);
        errorLabel.setForeground(Color.red);
        panelCustomerUpdate.add(errorLabel);

        List<Object> answer = MainApplication.controllerCustomer.selectFromId(MainApplication.updateId);
        if ((Boolean) answer.get(0)) {
            surnameField.setText((String) answer.get(1));
            nameField.setText((String) answer.get(2));
            ageField.setText(Integer.toString((int)answer.get(3)));
        } else {
            errorLabel.setText("Une erreur est survenue lors de la récupération des données. Quittez et réessayez.");
        }


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                List<Object> answer= MainApplication.controllerCustomer.UpdateCustomer(surname, name, age);
                Boolean success = (Boolean) answer.get(0);
                String errorMessage = (String) answer.get(1);

                if(success) {
                    MainApplication.accueil.CustomerCRUD("display");
                } else {
                    errorLabel.setText(errorMessage);
                }

            }
        });


        return panelCustomerUpdate;
    }

}
