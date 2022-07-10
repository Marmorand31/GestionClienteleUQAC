package com.architecture.project;


import javax.swing.*;

public class MainApplication {
    public static boolean loggedIn = false;
    public static boolean adminRole = false;
    public static void main(String[] args) {

        System.out.println("Welcome in a functioning project !!! :)");
        new Accueil();
        // Test database connection
//        Select CustomerTableSelect = new Select("Customers");
//        CustomerTableSelect.selectAll();


    }
}
