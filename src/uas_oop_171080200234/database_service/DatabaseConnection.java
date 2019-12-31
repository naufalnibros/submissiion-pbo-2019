/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.ini4j.Wini;
import uas_oop_171080200234.ui.DatabaseApp;
import uas_oop_171080200234.utils.MessageDialog;

/**
 *
 * @author naufalnibros
 */
public final class DatabaseConnection implements DatabaseApp.OnWriteDatabase {
    
    public static final String DATABASE_INI = "database.ini";
    
    private static final String KEY_INI = "connection_database";
    
    private OnAccess onAccessListener;
    
    private static DatabaseConnection instance;
    
    private boolean issetDatabaseIni = true;
    
    private Connection connection;
    
    private String url;
    
    private String username;
    
    private String password;
    
    private DatabaseConnection() throws SQLException {
        setConnection();
    }
    
    private DatabaseConnection(OnAccess onAccessListener) throws SQLException {
        this.onAccessListener = onAccessListener;
        setConnection(onAccessListener);
    }
        
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
        
    public static DatabaseConnection getInstance(OnAccess onAccessListener) throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection(onAccessListener);
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection(onAccessListener);
        }

        return instance;
    }
    
    private void setConnection(){
        getIniFile();
        
        if(!issetDatabaseIni) return;
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            MessageDialog.setMessage("Terjadi Kesalahan !", "Database Connection Creation Failed (setConnection) : " + ex.getMessage(), () -> System.exit(0) );
        }
    }
    
    public void setConnection(OnAccess onAccessListener){        
        getIniFile();
        
        if(!issetDatabaseIni) return;
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            if(onAccessListener != null) onAccessListener.canAccess();
        } catch (ClassNotFoundException | SQLException ex) {
            MessageDialog.setMessage("Terjadi Kesalahan !", "Database Connection Creation Failed (setConnection) : " + ex.getMessage(), () -> {
                new DatabaseApp()
                        .setVisibility(true)
                        .setOnWriteDatabase(this);
            });
        }
    }
    
    private void getIniFile(){
        File databaseIniFile = new File(DATABASE_INI);
        
        issetDatabaseIni = true; 
        
            try {
                if(!(databaseIniFile.isFile())) {
                    try {
                        databaseIniFile.createNewFile();
                        MessageDialog.setMessage("Informasi Penting !",
                                "File database.ini Anda telah dibuat, Silahkan ubah sesuai koneksi Database Local Anda. \n Lokasi File : " + databaseIniFile.getAbsolutePath(), 
                                () -> new DatabaseApp()
                                        .setVisibility(true)
                                        .setOnWriteDatabase(this));
                        issetDatabaseIni = false;
                        return;
                    } catch (IOException e) {
                        MessageDialog.setMessage("Error saat membuat database.ini file : " + e.getMessage(), "Terjadi Kesalahan !", () -> System.exit(0));
                    }
                }
                
                Wini ini = new Wini(databaseIniFile);
                
                url = ini.get(KEY_INI, "url");
                username = ini.get(KEY_INI, "username");
                password = ini.get(KEY_INI, "password");

                if (url == null || username == null || password == null) {
                    MessageDialog.setMessage("Informasi Penting !",
                        "File database.ini Anda telah dibuat, Silahkan ubah sesuai koneksi Database Local Anda. \n Lokasi File : " + databaseIniFile.getAbsolutePath(), 
                        () -> new DatabaseApp()
                                .setVisibility(true)
                                .setOnWriteDatabase(this));
                    issetDatabaseIni = false;
                }
                
            } catch (IOException e) {
                MessageDialog.setMessage("Terjadi Kesalahan !", "Database Connection Creation Failed : " + e.getMessage(), () -> System.exit(0));
            }
    }
    
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void onFinishWrite() {
        setConnection(onAccessListener);
    }
    
    public interface OnAccess {
        void canAccess();
    }
}
