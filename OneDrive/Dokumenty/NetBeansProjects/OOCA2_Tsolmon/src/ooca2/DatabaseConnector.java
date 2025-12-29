/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnector
 * -----------------
 * Handles database connection logic using JDBC.
 *
 * Demonstrates:
 *  - Database connector class (separation of concerns)
 *  - Exception handling using try–catch
 *  - Proper resource management
 */
public class DatabaseConnector {

    // Database connection details (example values)
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/ooca2_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    /**
     * Establishes and returns a database connection.
     *
     * @return Connection object if successful
     * @throws SQLException if a database access error occurs
     */
    public Connection getConnection() throws SQLException {

        try {
            // Attempt to establish database connection
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            System.out.println("Database connection established successfully.");
            return connection;

        } catch (SQLException e) {
            // Handle database connection failure
            System.out.println("Database connection failed: " + e.getMessage());
            throw e; // rethrow for caller to handle
        }
    }

    /**
     * Safely closes a database connection.
     *
     * @param connection the Connection to close
     */
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}

