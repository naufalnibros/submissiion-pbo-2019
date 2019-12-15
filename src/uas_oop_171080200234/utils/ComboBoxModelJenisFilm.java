/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.utils;

import javax.swing.DefaultComboBoxModel;
import uas_oop_171080200234.database_service.models.JenisFilm;

/**
 *
 * @author naufalnibros
 */
public class ComboBoxModelJenisFilm extends DefaultComboBoxModel<JenisFilm>{

    public ComboBoxModelJenisFilm(JenisFilm[] items) {
        super(items);
    }

    @Override
    public JenisFilm getSelectedItem() {
        return (JenisFilm) super.getSelectedItem();
    }
    
}
