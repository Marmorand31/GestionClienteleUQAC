package com.architecture.project.clientsCRUD;

// Placeholder à modifier quand nécessaire

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomerDisplay {

    public JPanel display() {
        JPanel panelCustopmerDisplay = new JPanel();
        panelCustopmerDisplay.setLayout(null);

        JLabel headerLabel = new JLabel("Gestion des clients");
        headerLabel.setBounds(330,40,180,40);
        panelCustopmerDisplay.add(headerLabel);


        JButton addButton = new JButton("Nouveau client");
        addButton.setBounds(30,100,180,30);
        panelCustopmerDisplay.add(addButton);

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
        panelCustopmerDisplay.add(js);

        return panelCustopmerDisplay;
    }
}
