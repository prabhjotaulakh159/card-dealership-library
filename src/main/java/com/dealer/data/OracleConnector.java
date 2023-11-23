package com.dealer.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    public OracleConnector() throws LoaderException {
        try {
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@198.168.52.211:1521/pdbora19c.dawsoncollege.qc.ca", "A2034747", "Jagdish123");
        } catch (SQLException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Accessor for connection
     * @return Current connection to the database
     */
    public Connection getConnection() {
        return this.connection;
    }
}
