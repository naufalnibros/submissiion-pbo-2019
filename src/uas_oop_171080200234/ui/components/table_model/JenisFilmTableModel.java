/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.ui.components.table_model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uas_oop_171080200234.database_service.models.JenisFilm;

/**
 *
 * @author naufalnibros
 */
public class JenisFilmTableModel extends AbstractTableModel {
    
    private List<JenisFilm> list = new ArrayList<>();
    
    private final String[] columnNames = new String[] {
            "No.", "Kode", "Keterangan"
    };
    
    private final Class[] columnClass = new Class[] {
        String.class, String.class, String.class
    };    

    public JenisFilmTableModel(List<JenisFilm> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return columnClass[columnIndex];
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        JenisFilm data = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(data.getNo());
            case 1:
                return data.getKode();
            case 2:
                return data.getJenis();
            default:
                break;
        }
        return null;
    }
    
}
