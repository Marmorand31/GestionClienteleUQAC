package com.architecture.project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Accueil extends JFrame{
    //Les deux panels de ta fenetre
    JPanel panelAccueil = new JPanel();
    JPanel panelAffichageClients = new JPanel();
    //Le bouton qui va changer le panel
    JButton bChangerPanel = new JButton("Tester changement");

    //Constructeur de ta fenêtre
    public Accueil(){
        //Paramètres (tu règles selon tes envies)
        super("Fenetre de test");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //Ecouteur sur le bouton
        this.bChangerPanel.addActionListener(new EcouteurBoutonChanger());
        //Par défaut, on place le bouton dans le premier panel qui est dans la fenêtre
        this.panelAccueil.add(this.bChangerPanel);
        this.setContentPane(this.panelAccueil);
        //Couleur des panels (pour voir le changement)
        this.panelAccueil.setBackground(Color.red);
        this.panelAffichageClients.setBackground(Color.blue);
    }

    //Méthode qui change le panel de ta fenêtre
    public void changerMenu(){
        this.setContentPane(this.panelAffichageClients);
        this.revalidate();
    }

    //Ecouteur de ton bouton
    public class EcouteurBoutonChanger implements ActionListener{
        public void actionPerformed(ActionEvent clic) {
            //Appelle la méthode de changement de panel
            Accueil.this.changerMenu();
        }
    }

    //Lanceur
    public static void main(String[] args){
        Accueil fen = new Accueil();
    }
}