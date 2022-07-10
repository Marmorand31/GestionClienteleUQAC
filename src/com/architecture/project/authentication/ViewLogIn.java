package com.architecture.project.authentication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewLogIn {

    // TODO : Form to log in the app
    public JPanel display() {
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.YELLOW);


//        JLabel label = new JLabel("Je suis un JLabel", JLabel.CENTER);
//        panelLogin.add(label);

        panelLogin.setLayout(null);

        JLabel headerLabel = new JLabel("Connexion");
        headerLabel.setBounds(375,160, 100, 40);
        panelLogin.add(headerLabel);

        JLabel loginLabel = new JLabel("Identifiant");
        loginLabel.setBounds(320,230, 70, 25);
        panelLogin.add(loginLabel);
        JTextField loginField = new JTextField();
        loginField.setBounds(390,230, 100, 25);
        panelLogin.add(loginField);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(300,270, 100, 25);
        panelLogin.add(passwordLabel);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(390,270, 100, 25);
        panelLogin.add(passwordField);

        JButton loginButton = new JButton("Valider");
        loginButton.setBounds(350, 320, 100, 25);
        panelLogin.add(loginButton);






        return panelLogin;
    }

}
