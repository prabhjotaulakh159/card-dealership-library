package com.dealer.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dealer.DatabaseCredentials;
import com.dealer.data.exceptions.LoaderException;

/**
 * Provides a connection to oracle database among different sub-types
 * that read/write to oracle
 * @author Prabhjot Aulakh, Safin Haque
 */
public abstract class OracleConnector {
    private Connection connection;
    /**
     * Initializes a connection to the database
     * @throws LoaderException If the connection fails
     */
    public OracleConnector() {
        try {
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@198.168.52.211:1521/pdbora19c.dawsoncollege.qc.ca", DatabaseCredentials.USERNAME, DatabaseCredentials.PASSWORD);
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("It appears that you have attempted to connect to oracle, but the credentials were invalid and/or empty");
            System.out.println("Please provide valid credentials in the DatabaseCredentials.java file");
            System.out.println("If you do not wish to connect to oracle, simply change the source to Source.CSV within the main methods of display/AdminApp.java or display/EmployeeApp.java");
            System.exit(0);
        }
    }

    /**
     * Accessor for connection
     * @return Current connection to the database
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Allows to rollback changes to the db
     */
    public void rollback() {
        try {
            this.connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
