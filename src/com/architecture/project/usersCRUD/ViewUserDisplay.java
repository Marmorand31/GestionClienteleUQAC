package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;
import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewUserDisplay{

    public JPanel display() {
        JPanel userDisplayPanel = new JPanel();
        userDisplayPanel.setLayout(null);

        JLabel headerLabel = new JLabel("Gestion des utilisateurs");
        headerLabel.setBounds(330,40,180,40);
        userDisplayPanel.add(headerLabel);


        JButton addButton = new JButton("Nouvel utilisateur");
        addButton.setBounds(30,100,180,30);
        userDisplayPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.UserCRUD("creation");
            }
        });

        return userDisplayPanel;
    }
}
