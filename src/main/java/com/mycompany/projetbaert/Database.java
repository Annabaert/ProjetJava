package com.mycompany.projetbaert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annabelle
 */
public class Database {

    public static volatile Database instance = null;
    private Connection connection;

    public final static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            String path = Paths.get("C:\\Users\\annabelle\\Downloads\\status.db").toString();
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s ", path));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
