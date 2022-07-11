package com.architecture.project;


import com.architecture.project.authentication.ControllerAuthentication;
import com.architecture.project.usersCRUD.ControllerUser;


public class MainApplication {
    public static boolean loggedIn = false;
    public static boolean adminRole = false;
    public static Accueil accueil;
    public static ControllerAuthentication controllerAuthentication;
    public static ControllerUser controllerUser;
    public static void main(String[] args) {

        System.out.println("Welcome in a functioning project !!! :)");
        controllerAuthentication = new ControllerAuthentication();
        controllerUser = new ControllerUser();
        accueil = new Accueil();
        // Test database connection
//        Select CustomerTableSelect = new Select("Customers");
//        CustomerTableSelect.selectAll();


    }
}
