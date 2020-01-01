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
import uas_oop_171080200234.database_service.models.VCD;

/**
 *
 * @author naufalnibros
 */
public class VCDRepository implements RepositoryInterface<VCD>{
    
    private DatabaseInterface databaseInterface;

    @Override
    public void create(VCD object) {
        String SQL = "INSERT INTO vcd(kd_vcd, nm_vcd, kd_jns, hrg_sewa, nil_denda) VALUES(?,?,?,?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, object.getKode());
            preparedStatement.setString(2, object.getNama());
            preparedStatement.setString(3, object.getJenisFilm().getKode());
            preparedStatement.setInt(4, object.getHarga());
            preparedStatement.setInt(5, object.getNilaidenda());
            
            boolean isSuccess = !preparedStatement.execute();
            
            if (databaseInterface != null) {
                if (isSuccess) {
                    databaseInterface.onSuccess();
                } else {
                    databaseInterface.onError("Terjadi Kesalahan saat menyimpan data");
                }
            }            
        } catch (SQLException e) {
            if (databaseInterface != null) databaseInterface.onError(e.getMessage());
        }
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
        
        List<VCD> list = new ArrayList<>();
        String SQL = "SELECT * FROM vcd " +
                     "LEFT JOIN jenis_film " +
                     "ON jenis_film.kd_jns = vcd.kd_jns " +
                     "ORDER BY kd_vcd DESC;";
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            int iterator = 1;
            
            while(resultSet.next()){
                list.add(new VCD(
                        iterator,
                        resultSet.getString("kd_vcd"), 
                        resultSet.getString("nm_vcd"), 
                        resultSet.getInt("hrg_sewa"),
                        resultSet.getInt("nil_denda"), 
                        new JenisFilm(resultSet.getString("kd_jns"), resultSet.getString("ket_jns"))
                ));
                iterator++;
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

    @Override
    public List<VCD> search(String query) {
        List<VCD> list = new ArrayList<>();
        String SQL = "SELECT * FROM vcd " +
                     "LEFT JOIN jenis_film " +
                     "ON jenis_film.kd_jns = vcd.kd_jns " +
                     "WHERE vcd.kd_vcd LIKE ? "
                + "OR vcd.nm_vcd LIKE ? "
                + "OR jenis_film.kd_jns LIKE ? "
                + "OR jenis_film.ket_jns LIKE ? " +
                     "ORDER BY kd_vcd DESC;";        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, "%" + (query == null ? "" : query) + "%");
            preparedStatement.setString(2, "%" + (query == null ? "" : query) + "%");
            preparedStatement.setString(3, "%" + (query == null ? "" : query) + "%");
            preparedStatement.setString(4, "%" + (query == null ? "" : query) + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            int iterator = 1;
            
            while(resultSet.next()){
                list.add(new VCD(
                        iterator,
                        resultSet.getString("kd_vcd"), 
                        resultSet.getString("nm_vcd"), 
                        resultSet.getInt("hrg_sewa"),
                        resultSet.getInt("nil_denda"), 
                        new JenisFilm(resultSet.getString("kd_jns"), resultSet.getString("ket_jns"))
                ));
                iterator++;
            }
                    
        } catch (SQLException ex) {
            if (databaseInterface != null) databaseInterface.onError(ex.getMessage());
        }
        
        if (databaseInterface != null) databaseInterface.onResult(list);
        
        return list;
    }

    @Override
    public ResultSet getReport() {
        String SQL = "SELECT * FROM vcd " +
                     "LEFT JOIN jenis_film " +
                     "ON jenis_film.kd_jns = vcd.kd_jns " +
                     "ORDER BY kd_vcd DESC;";
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            if (databaseInterface != null) databaseInterface.onError( "Result Set : " + ex.getMessage());
        }
        
        return null;
    }
    
}
