package com.architecture.project;

import com.architecture.project.usersCRUD.ViewUserDisplay;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Accueil {
    JFrame frame = new JFrame("CardLayout demo");
    JPanel panelCont = new JPanel();
    JPanel panelFirst = new JPanel();
    //JPanel panelSecond = new JPanel();
    JButton buttonOne = new JButton("Switch to second panel/workspace");
    //JButton buttonSecond = new JButton("Switch to first panel/workspace");
    CardLayout cl = new CardLayout();

    public Accueil() {
        panelCont.setLayout(cl);

        panelFirst.add(buttonOne);
        panelFirst.setBackground(Color.BLUE);
        ViewUserDisplay view = new ViewUserDisplay();
        JPanel userDisplay = view.display();
        panelCont.add(panelFirst, "1");
        panelCont.add(userDisplay, "2");
        cl.show(panelCont, "1");

        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}