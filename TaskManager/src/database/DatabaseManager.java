package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/taskdb";
                String user = "root";
                String pass = "8129057270";

                // Assign the connection to the static variable
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Connected to the database successfully!");

            } catch (Exception e) {
                System.out.println("Database connection failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
