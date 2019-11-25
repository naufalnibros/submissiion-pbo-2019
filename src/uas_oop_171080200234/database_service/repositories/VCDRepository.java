/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service.repositories;

import java.util.ArrayList;
import java.util.List;
import uas_oop_171080200234.database_service.DatabaseInterface;
import uas_oop_171080200234.database_service.models.VCD;

/**
 *
 * @author naufalnibros
 */
public class VCDRepository implements RepositoryInterface<VCD>{
    
    private DatabaseInterface databaseInterface;

    @Override
    public void create(VCD object) {
        
    }

    @Override
    public void update(VCD object) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public VCD find() {
        return new VCD();
    }

    @Override
    public List<VCD> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void setListener(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }
    
}
