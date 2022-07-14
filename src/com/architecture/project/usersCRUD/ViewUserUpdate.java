package com.architecture.project.usersCRUD;

import com.architecture.project.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewUserUpdate {

    public JPanel display() {
        JPanel panelUserUpdate = new JPanel();
        panelUserUpdate.setLayout(null);


        JLabel headerLabel = new JLabel("Modification d'un utilisateur");
        headerLabel.setBounds(330,40,180,40);
        panelUserUpdate.add(headerLabel);

        JLabel surnameLabel = new JLabel("Nom");
        surnameLabel.setBounds(320,150, 70, 25);
        panelUserUpdate.add(surnameLabel);
        JTextField surnameField = new JTextField();
        surnameField.setBounds(390,150, 100, 25);
        panelUserUpdate.add(surnameField);

        JLabel nameLabel = new JLabel("Prénom");
        nameLabel.setBounds(320,190, 100, 25);
        panelUserUpdate.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(390,190, 100, 25);
        panelUserUpdate.add(nameField);

        JLabel adminLabel = new JLabel("Administrateur");
        adminLabel.setBounds(300,230, 100, 25);
        panelUserUpdate.add(adminLabel);
        JCheckBox adminCheckB = new JCheckBox();
        adminCheckB.setBounds(390,230, 25, 25);
        panelUserUpdate.add(adminCheckB);

        JLabel loginLabel = new JLabel("Identifiant");
        loginLabel.setBounds(320,270, 70, 25);
        panelUserUpdate.add(loginLabel);
        JTextField loginField = new JTextField();
        loginField.setBounds(390,270, 100, 25);
        panelUserUpdate.add(loginField);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(300,310, 100, 25);
        panelUserUpdate.add(passwordLabel);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(390,310, 100, 25);
        panelUserUpdate.add(passwordField);

        JLabel passwordConfirmLabel = new JLabel("Confirmation du mot de passe");
        passwordConfirmLabel.setBounds(210,350, 200, 25);
        panelUserUpdate.add(passwordConfirmLabel);
        JTextField passwordConfirmField = new JTextField();
        passwordConfirmField.setBounds(390,350, 100, 25);
        panelUserUpdate.add(passwordConfirmField);

        JButton backButton = new JButton("Annuler");
        backButton.setBounds(300, 400, 100, 25);
        panelUserUpdate.add(backButton);

        JButton createButton = new JButton("Modifier");
        createButton.setBounds(410, 400, 100, 25);
        panelUserUpdate.add(createButton);

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(180,450, 500, 25);
        errorLabel.setForeground(Color.red);
        panelUserUpdate.add(errorLabel);

        List<Object> answer = MainApplication.controllerUser.selectFromId(MainApplication.updateId);
        System.out.println(answer);
        if ((Boolean) answer.get(0)) {
            surnameField.setText((String) answer.get(1));
            nameField.setText((String) answer.get(2));
            adminCheckB.setSelected((Boolean) answer.get(3));
            loginField.setText((String) answer.get(4));

        } else {
            errorLabel.setText("Une erreur est survenue lors de la récupération des données. Quittez et réessayez.");
        }


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");
                surnameField.setText("");
                nameField.setText("");
                adminCheckB.setSelected(false);
                loginField.setText("");
                passwordField.setText("");
                passwordConfirmField.setText("");
                MainApplication.accueil.UserCRUD("display");
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");

                String surname = surnameField.getText();
                String name = nameField.getText();
                Boolean admin = adminCheckB.isSelected();
                String login = loginField.getText();
                String pwd = passwordField.getText();
                String pwdConfirm = passwordConfirmField.getText();

                List<Object> answer= MainApplication.controllerUser.CreateUser(surname, name, admin, login, pwd, pwdConfirm);
                Boolean success = (Boolean) answer.get(0);
                String errorMessage = (String) answer.get(1);

                if(success) {
                    MainApplication.accueil.UserCRUD("display");
                    surnameField.setText("");
                    nameField.setText("");
                    adminCheckB.setSelected(false);
                    loginField.setText("");
                    passwordField.setText("");
                    passwordConfirmField.setText("");

                } else {
                    errorLabel.setText(errorMessage);
                }

            }
        });


        return panelUserUpdate;
    }

}
