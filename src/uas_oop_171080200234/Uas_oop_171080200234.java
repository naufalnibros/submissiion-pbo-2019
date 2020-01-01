/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234;

import java.sql.SQLException;
import uas_oop_171080200234.database_service.DatabaseConnection;
import uas_oop_171080200234.ui.panel.MainPanel;

/**
 *
 * @author naufalnibros
 */
public class Uas_oop_171080200234 {
    
    public static void main(String[] args) throws SQLException {
        DatabaseConnection.getInstance(() -> {
            new MainPanel().setVisible(true);
        });
    }
    
}
