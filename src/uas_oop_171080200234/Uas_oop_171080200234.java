/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234;

import java.sql.SQLException;
import java.util.List;
import uas_oop_171080200234.database_service.DatabaseConnection;
import uas_oop_171080200234.database_service.DatabaseFactory;
import uas_oop_171080200234.database_service.DatabaseInterface;
import uas_oop_171080200234.database_service.DatabaseConst;
import uas_oop_171080200234.database_service.models.JenisFilm;
import uas_oop_171080200234.database_service.repositories.RepositoryInterface;
import uas_oop_171080200234.ui.MainApp;

/**
 *
 * @author naufalnibros
 */
public class Uas_oop_171080200234 {
   
    private static MainApp mainApp;
    
    private static RepositoryInterface jenisFilm;

    public static void main(String[] args) throws SQLException {
        
        DatabaseConnection.getInstance().getConnection();
        
//        new Uas_oop_171080200234().initDatabase();
//        
//        jenisFilm.create(new JenisFilm());
        
//        mainApp = new MainApp();
//        mainApp.setVisible(true);
//        mainApp.setOnListener(() -> {
//            mainApp.setVisible(false);
//            System.exit(0);
//        });

    }
    
    void initDatabase(){
        jenisFilm = DatabaseFactory.from(DatabaseConst.TABLE_JENIS_FILM).setListener(DATABASE_INTERFACE);
    }
    
    private static final DatabaseInterface<JenisFilm> DATABASE_INTERFACE = new DatabaseInterface<JenisFilm>() {
        
        @Override
        public void onResult(List<JenisFilm> list) {
            list.forEach((t) -> {
                System.out.println("asdasd" + t.getKode());
            });
        }

        @Override
        public void onSuccess() {
     
        }

        @Override
        public void onError() {
     
        }

        @Override
        public void onProcess() {
     
        }
    };
    
}
