/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service;

import uas_oop_171080200234.database_service.repositories.JenisFilmRepository;
import uas_oop_171080200234.database_service.repositories.RepositoryInterface;
import uas_oop_171080200234.database_service.repositories.VCDRepository;

/**
 *
 * @author naufalnibros
 */
public class DatabaseFactory {
    
    private static RepositoryInterface repositoryInterface;
    
    public static DatabaseFactory from(int table){
        switch(table) {
            case DatabaseConst.TABLE_JENIS_FILM : {
                repositoryInterface = new JenisFilmRepository();
                break;
            }
            case DatabaseConst.TABLE_VCD : {
                repositoryInterface = new VCDRepository();
                break;
            }
            default: {
                return null;
            }
        }
        
        return new DatabaseFactory();
    }
    
    public RepositoryInterface setListener(DatabaseInterface databaseInterface){
        repositoryInterface.setListener(databaseInterface);
        return repositoryInterface;
    }
    
}
