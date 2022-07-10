package com.architecture.project.authentication;

import com.architecture.project.Accueil;
import com.architecture.project.MainApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewLogIn {


    // Form to log in the app
    ControllerAuthentication CA = new ControllerAuthentication();

    public JPanel display() {
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.YELLOW);
        panelLogin.setLayout(null);

        JLabel headerLabel = new JLabel("Connexion");
        headerLabel.setBounds(370,160, 100, 40);
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
        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(280,350, 250, 25);
        errorLabel.setForeground(Color.red);
        panelLogin.add(errorLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                errorLabel.setText("");
                String login = loginField.getText();
                String password = passwordField.getText();

                if(!CA.Authentication(login, password)){
                    errorLabel.setText("Identifiant ou Mot de passe incorrect !");
                }
            }
        });

        return panelLogin;
    }

}
