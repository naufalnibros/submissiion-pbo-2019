/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service.repositories;

import java.sql.ResultSet;
import java.util.List;
import uas_oop_171080200234.database_service.DatabaseInterface;

/**
 *
 * @author naufalnibros
 * @param <T> Object Model
 */
public interface RepositoryInterface<T> {
    void setListener(DatabaseInterface databaseInterface);
    void create(T object);
    void update(T object);
    void delete(String id);
    List<T> search(String query);
    T find();
    List<T> findAll();
    ResultSet getReport();
}
