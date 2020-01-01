/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and jasper the template in the editor.
 */
package uas_oop_171080200234.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.HashMap;
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
public class OpenUtils {
    
    private final String title;
    
    private final Component component;
    
    private final JDesktopPane deksDesktopPane;
    
    public static OpenUtils set(String title, Component component, JDesktopPane deksDesktopPane) {
        return new OpenUtils(title, component, deksDesktopPane);
    }

    private OpenUtils(String title, Component component, JDesktopPane deksDesktopPane) {
        this.title = title;
        this.component = component;
        this.deksDesktopPane = deksDesktopPane;
    }
    
     /** openReport
     * @param resultSet
     * @param locationReport Ex :  ./Report/FileReport.jasper */
    public void jasper(ResultSet resultSet, String locationReport){ 
        try {
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
            JasperPrint jasperPrint = JasperFillManager.fillReport(locationReport, new HashMap(), resultSetDataSource);
            JRViewer viewer = new JRViewer(jasperPrint);
            JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
            internalFrame.add(viewer);
            internalFrame.setSize(deksDesktopPane.getWidth(), deksDesktopPane.getHeight());
                  
            /** open JInternalFrame  */
            frame(internalFrame, deksDesktopPane);
            
        } catch (JRException | ExceptionInInitializerError ex) {
            JOptionPane.showMessageDialog(component, "Could not create the report : " + ex.getMessage() + " " + ex.getLocalizedMessage());
        }
    }
    
    public static void frame(JInternalFrame form, JDesktopPane dekstopPane){
        Dimension desktopSize = dekstopPane.getSize();
        Dimension jInternalFrameSize = form.getSize();
        form.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        dekstopPane.add(form);        
        form.setVisible(true);
    }
}
