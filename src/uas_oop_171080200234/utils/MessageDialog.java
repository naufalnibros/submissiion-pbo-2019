/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author naufalnibros
 */
public class MessageDialog {
    
    public static void setMessage(String title, String message, OnMessageCallback callback){
       int input = JOptionPane.showOptionDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
       
        if (input == JOptionPane.OK_OPTION) {
            if(callback != null) callback.OkeListener();
        }
    }
    
    public interface OnMessageCallback{
        void OkeListener();
    }
    
}
