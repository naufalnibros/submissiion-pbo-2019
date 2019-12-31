/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.utils;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author naufalnibros
 */
public class JasperUtils {
    
    private final String title;
    
    private final Component component;
    
    public static JasperUtils set(String title, Component component) {
        return new JasperUtils(title, component);
    }

    private JasperUtils(String title, Component component) {
        this.title = title;
        this.component = component;
    }
    
     /** openReport
     * @param resultSet
     * @param locationReport Ex :  ./Report/FileReport.jasper */
    public void open(ResultSet resultSet, String locationReport){ 
        try {
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
            JasperPrint jasperPrint = JasperFillManager.fillReport(locationReport, new HashMap(), resultSetDataSource);
            JRViewer viewer = new JRViewer(jasperPrint);
            JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
            internalFrame.add(viewer);
            internalFrame.setVisible(true);
        } catch (JRException | ExceptionInInitializerError ex) {
            JOptionPane.showMessageDialog(component, "Could not create the report : " + ex.getMessage() + " " + ex.getLocalizedMessage());
        }
    }
}
