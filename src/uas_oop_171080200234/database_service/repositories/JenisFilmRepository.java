/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service.repositories;

import java.util.ArrayList;
import java.util.List;
import uas_oop_171080200234.database_service.DatabaseInterface;
import uas_oop_171080200234.database_service.models.JenisFilm;

/**
 *
 * @author naufalnibros
 */
public class JenisFilmRepository implements RepositoryInterface<JenisFilm>{
    
    DatabaseInterface databaseInterface;

    @Override
    public void create(JenisFilm object) {
        
        List<JenisFilm> list = new ArrayList<>();
        
        list.add(new JenisFilm("kjh23", "asdasd"));
        list.add(new JenisFilm("l34", "asdasd"));
        list.add(new JenisFilm("jn445", "asdasd"));
        list.add(new JenisFilm("23j3", "asdasd"));
        
        System.out.println("HALO BANDUNG");
        if (databaseInterface != null) {
            databaseInterface.onSuccess();            
            databaseInterface.onResult(list);
        }
        
    }

    @Override
    public void update(JenisFilm object) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public JenisFilm find() {
        return new JenisFilm();
    }

    @Override
    public List<JenisFilm> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void setListener(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }
}
