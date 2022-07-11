package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainApplication.accueil.UserCRUD("creation");
            }
        });


        Object[][] data = MainApplication.controllerUser.selectAll();

        String[] columns = new String[]{"Id", "Surname", "Name", "Admin", "Password", "Login"};

        JTable table = new JTable(data,columns);
        table.setFillsViewportHeight(true);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(50,150,700,400);
        panelUserDisplay.add(js);

        return panelUserDisplay;
    }
}

