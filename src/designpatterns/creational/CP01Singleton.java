package designpatterns.creational;

public class CP01Singleton {
    private static CP01Singleton instance;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;

    private CP01Singleton() {
        // Private constructor to prevent instantiation
    }

    public static CP01Singleton getInstance() {
        if (instance == null) {
            instance = new CP01Singleton();
            // In a real application, you would load configuration settings from a file or database
            instance.loadConfiguration();
        }
        return instance;
    }

    public static void main(String[] args) {
        CP01Singleton configManager = CP01Singleton.getInstance();
        System.out.println("Database URL: " + configManager.getDatabaseUrl());
        System.out.println("Database Username: " + configManager.getDatabaseUsername());
        System.out.println("Database Password: " + configManager.getDatabasePassword());
    }

    private void loadConfiguration() {
        // Simulating loading configuration from a file
        this.databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        this.databaseUsername = "username";
        this.databasePassword = "password";
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getDatabaseUsername() {
        return this.databaseUsername;
    }

    public String getDatabasePassword() {
        return this.databasePassword;
    }

}


