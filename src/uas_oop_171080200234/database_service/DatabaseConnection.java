/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.ini4j.Wini;

/**
 *
 * @author naufalnibros
 */
public class DatabaseConnection {
    
    private static final String KEY_INI = "connection_database";
    
    private static final String DIR_INI = "src/uas_oop_171080200234/database.ini";
    
    private static DatabaseConnection instance;
    
    private Connection connection;
    
    private String url = "jdbc:postgresql://localhost:5432/pbo";
    
    private String username = "naufalnibros";
    
    private String password = "naufalnibros";
    
    private DatabaseConnection() throws SQLException {
        
        if (!getIniFile()) {
            System.out.println("database.ini tidak terbaca");
            return;
        }
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
    private boolean getIniFile(){
        try {
            Wini ini = new Wini(new File(Paths.get(DIR_INI).toAbsolutePath().toString()));
            
            url = ini.get(KEY_INI, "url");
            username = ini.get(KEY_INI, "username");
            password = ini.get(KEY_INI, "password");
            
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
