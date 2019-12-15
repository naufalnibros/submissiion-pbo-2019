/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uas_oop_171080200234.database_service.DatabaseConnection;
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
        String SQL = "INSERT INTO jenis_film(kd_jns, ket_jns) VALUES(?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, object.getKode());
            preparedStatement.setString(2, object.getJenis());
            
            boolean isSuccess = !preparedStatement.execute();
            
            if (databaseInterface != null) {
                if (isSuccess) {
                    databaseInterface.onSuccess();
                } else {
                    databaseInterface.onError("Terjadi Kesalahan");
                }
            }            
        } catch (SQLException e) {
            if (databaseInterface != null) databaseInterface.onError(e.getMessage());
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
        List<JenisFilm> list = new ArrayList<>();
        String SQL = "SELECT * FROM jenis_film ORDER BY kd_jns DESC";
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                list.add(new JenisFilm(resultSet.getString("kd_jns"), resultSet.getString("ket_jns")));
            }
                    
        } catch (SQLException ex) {
            if (databaseInterface != null) databaseInterface.onError(ex.getMessage());
        }
        
        if (databaseInterface != null && !list.isEmpty()) databaseInterface.onResult(list);
        
        return list;
    }

    @Override
    public void setListener(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }
}
