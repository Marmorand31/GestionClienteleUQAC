package com.architecture.project;

import com.architecture.project.authentication.ViewLogIn;
import com.architecture.project.customersCRUD.ViewCustomerCreation;
import com.architecture.project.customersCRUD.ViewCustomerDisplay;
import com.architecture.project.customersCRUD.ViewCustomerUpdate;
import com.architecture.project.searchTool.ViewSearchTool;
import com.architecture.project.usersCRUD.ViewUserCreation;
import com.architecture.project.usersCRUD.ViewUserDisplay;
import com.architecture.project.usersCRUD.ViewUserUpdate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Accueil {
    JFrame frame = new JFrame("GestionClienteleUQAC");
    JPanel panelCont = new JPanel();
    JPanel panelHome = new JPanel();
    JButton bLogOut = new JButton("Deconnexion");
    JButton bUserDisplay = new JButton("Gestion des utilisateurs");
    JButton bCustomerDisplay = new JButton("Gestion des clients");
    JButton bCustomerSearch = new JButton("Recherche d'un client");

    CardLayout cl = new CardLayout();

    ViewLogIn viewLogIn = new ViewLogIn();
    ViewCustomerDisplay viewCustomerDisplay = new ViewCustomerDisplay();
    ViewSearchTool viewSearchTool = new ViewSearchTool();
    ViewUserDisplay viewUserDisplay = new ViewUserDisplay();
    ViewUserCreation viewUserCreation = new ViewUserCreation();
    ViewCustomerCreation viewCustomerCreation = new ViewCustomerCreation();
    ViewUserUpdate viewUserUpdate = new ViewUserUpdate();
    ViewCustomerUpdate viewCustomerUpdate = new ViewCustomerUpdate();


    JPanel panelLogIn;
    JPanel panelCustomerDisplay;
    JPanel panelUSearchTool;
    JPanel panelUserDisplay;
    JPanel panelUserCreation;
    JLabel errorLabel = new JLabel("");
    JPanel panelCustomerCreation;
    JPanel panelUserUpdate;
    JPanel panelCustomerUpdate;


    public Accueil() {
        panelCont.setLayout(cl);

        panelHome.setLayout(null);
        errorLabel.setBounds(180,200,500,40);
        errorLabel.setForeground(Color.red);
        panelHome.add(errorLabel);

        bUserDisplay.setBounds(310,150,180,40);
        panelHome.add(bUserDisplay);

        bCustomerDisplay.setBounds(310,250,180,40);
        panelHome.add(bCustomerDisplay);

        bCustomerSearch.setBounds(310,350,180,40);
        panelHome.add(bCustomerSearch);

        bLogOut.setBounds(630,510,140,40);
        panelHome.add(bLogOut);

        panelLogIn = viewLogIn.display();
        panelCustomerDisplay = viewCustomerDisplay.display();
        panelUSearchTool = viewSearchTool.display();
        panelUserDisplay = viewUserDisplay.display();
        panelUserCreation = viewUserCreation.display();
        panelCustomerCreation = viewCustomerCreation.display();
        panelUserUpdate = viewUserUpdate.display();
        panelCustomerUpdate = viewCustomerUpdate.display();

        panelCont.add(panelHome, "1");
        panelCont.add(panelLogIn, "2");
        panelCont.add(panelCustomerDisplay, "3");
        panelCont.add(panelUSearchTool, "4");
        panelCont.add(panelUserDisplay, "5");
        panelCont.add(panelUserCreation, "6");
        panelCont.add(panelUserUpdate, "7");
        panelCont.add(panelCustomerCreation, "8");
        panelCont.add(panelCustomerUpdate, "9");

        cl.show(panelCont, "2");

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
                MainApplication.controllerAuthentication.disconnect();
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
                //cl.show(panelCont, "4");
            }
        });

        bUserDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                errorLabel.setText("");
                if (MainApplication.adminRole == true){
                    cl.show(panelCont, "5");
                }else{
                    errorLabel.setText("Vous n'avez pas les autorisations nécessaires pour accéder à cette fonctionnalité !");
                }

            }
        });

        frame.add(panelCont);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void BackHome() {
        cl.show(panelCont, "1");
    }

    public void Login(){
        cl.show(panelCont, "1");
    }
    public void UserCRUD(String cmd) {
        if (cmd == "display"){
            this.RefreshUserDisplay();
            cl.show(panelCont, "5");
        }
        if (cmd == "creation") {
            this.RefreshUserCreation();
            cl.show(panelCont, "6");
        }
        if (cmd == "update") {
            this.RefreshUserUpdate();
            cl.show(panelCont, "7");
        }
    }
    public void RefreshUserDisplay() {
        panelUserDisplay = viewUserDisplay.display();
        panelCont.add(panelUserDisplay, "5");
    }
    public void RefreshUserCreation() {
        panelUserCreation = viewUserCreation.display();
        panelCont.add(panelUserCreation, "6");
    }
    public void RefreshUserUpdate() {
        panelUserUpdate = viewUserUpdate.display();
        panelCont.add(panelUserUpdate, "7");
    }

    public void CustomerCRUD(String cmd) {
        if (cmd == "display"){
            this.RefreshCustomerDisplay();
            cl.show(panelCont, "3");
        }
        if (cmd == "creation"){
            this.RefreshCustomerCreation();
            cl.show(panelCont, "8");
        }
        if (cmd == "update"){
            this.RefreshCustomerUpdate();
            cl.show(panelCont, "9");
        }
    }
    public void RefreshCustomerDisplay() {
        panelCustomerDisplay = viewCustomerDisplay.display();
        panelCont.add(panelCustomerDisplay, "3");
    }
    public void RefreshCustomerCreation() {
        panelCustomerCreation = viewCustomerCreation.display();
        panelCont.add(panelCustomerCreation, "8");
    }
    public void RefreshCustomerUpdate() {
        panelCustomerUpdate = viewCustomerUpdate.display();
        panelCont.add(panelCustomerUpdate, "9");
    }

}