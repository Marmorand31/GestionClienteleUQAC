package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUserCreation {

    public JPanel display() {
        JPanel panelUCreation = new JPanel();
        panelUCreation.setLayout(null);

        JLabel headerLabel = new JLabel("Création d'un nouvel utilisateur");
        headerLabel.setBounds(330,40,180,40);
        panelUCreation.add(headerLabel);

        JLabel surnameLabel = new JLabel("Nom");
        surnameLabel.setBounds(320,150, 70, 25);
        panelUCreation.add(surnameLabel);
        JTextField surnameField = new JTextField();
        surnameField.setBounds(390,150, 100, 25);
        panelUCreation.add(surnameField);

        JLabel nameLabel = new JLabel("Prénom");
        nameLabel.setBounds(320,190, 100, 25);
        panelUCreation.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(390,190, 100, 25);
        panelUCreation.add(nameField);

        JLabel adminLabel = new JLabel("Administrateur");
        adminLabel.setBounds(300,230, 100, 25);
        panelUCreation.add(adminLabel);
        JCheckBox adminCheckB = new JCheckBox();
        adminCheckB.setBounds(390,230, 25, 25);
        panelUCreation.add(adminCheckB);

        JLabel loginLabel = new JLabel("Identifiant");
        loginLabel.setBounds(320,270, 70, 25);
        panelUCreation.add(loginLabel);
        JTextField loginField = new JTextField();
        loginField.setBounds(390,270, 100, 25);
        panelUCreation.add(loginField);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(300,310, 100, 25);
        panelUCreation.add(passwordLabel);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(390,310, 100, 25);
        panelUCreation.add(passwordField);

        JLabel passwordConfirmLabel = new JLabel("Confirmation du mot de passe");
        passwordConfirmLabel.setBounds(210,350, 200, 25);
        panelUCreation.add(passwordConfirmLabel);
        JTextField passwordConfirmField = new JTextField();
        passwordConfirmField.setBounds(390,350, 100, 25);
        panelUCreation.add(passwordConfirmField);

        JButton backButton = new JButton("Annuler");
        backButton.setBounds(300, 400, 100, 25);
        panelUCreation.add(backButton);

        JButton createButton = new JButton("Créer");
        createButton.setBounds(410, 400, 100, 25);
        panelUCreation.add(createButton);

        // TODO : listener bouton annuler
        // TODO : listener bouton créer
        // TODO : erreur si un champ text est vide
        // TODO : erreur si les deux mdp sont différents

        // TODO : calcul des erreurs dans la vue ou dans le controleur ???

//        JLabel errorLabel = new JLabel("");
//        errorLabel.setBounds(280,350, 250, 25);
//        errorLabel.setForeground(Color.red);
//        panelLogin.add(errorLabel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainApplication.accueil.UserCRUD("display");
            }
        });

//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                errorLabel.setText("");
//                String login = loginField.getText();
//                String password = passwordField.getText();
//
//                if(!MainApplication.controllerAuthentication.Authentication(login, password)){
//                    errorLabel.setText("Identifiant ou Mot de passe incorrect !");
//                }
//
//            }
//        });

        return panelUCreation;
    }

}
