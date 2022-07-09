package com.architecture.project;

public class MainApplication {
    public static void main(String[] args) {

        System.out.println("Welcome in a functioning project !!! :)");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://gestionclientele-72f65-default-rtdb.europe-west1.firebasedatabase.app/")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
