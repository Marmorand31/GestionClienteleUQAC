package com.architecture.project;

import com.architecture.project.authentication.ViewLogIn;
import com.architecture.project.authentication.ViewLogOut;
import com.architecture.project.clientsCRUD.ViewCustomerDisplay;
import com.architecture.project.searchTool.ViewSearchTool;
import com.architecture.project.usersCRUD.ViewUserDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Accueil {
    JFrame frame = new JFrame("CardLayout demo");
    JPanel panelCont = new JPanel();
    JPanel panelHome = new JPanel();
    JButton bLogOut = new JButton("Deconnexion");
    JButton bUserDisplay = new JButton("Gestion des utilisateurs");
    JButton bCustomerDisplay = new JButton("Gestion des clients");
    JButton bCustomerSearch = new JButton("Recherches d'un client");

    CardLayout cl = new CardLayout();

    public Accueil() {
        panelCont.setLayout(cl);

        panelHome.setLayout(null);

        bUserDisplay.setBounds(310,150,180,40);
        panelHome.add(bUserDisplay);

        bCustomerDisplay.setBounds(310,250,180,40);
        panelHome.add(bCustomerDisplay);

        bCustomerSearch.setBounds(310,350,180,40);
        panelHome.add(bCustomerSearch);

        bLogOut.setBounds(630,510,140,40);
        panelHome.add(bLogOut);

        ViewLogOut viewLogOut = new ViewLogOut();
        ViewCustomerDisplay viewCustomerDisplay = new ViewCustomerDisplay();
        ViewSearchTool viewSearchTool = new ViewSearchTool();
        ViewUserDisplay viewUserDisplay = new ViewUserDisplay();

        JPanel panelLogOut = viewLogOut.display();
        JPanel panelCustomerDisplay = viewCustomerDisplay.display();
        JPanel panelUSearchTool = viewSearchTool.display();
        JPanel panelUserDisplay = viewUserDisplay.display();

        panelCont.add(panelHome, "1");
        panelCont.add(panelLogOut, "2");
        panelCont.add(panelCustomerDisplay, "3");
        panelCont.add(panelUSearchTool, "4");
        panelCont.add(panelUserDisplay, "5");
        cl.show(panelCont, "1");

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        bCustomerDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "3");
            }
        });

        bCustomerSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "4");
            }
        });

        bUserDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "5");
            }
        });

        frame.add(panelCont);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}