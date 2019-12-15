/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.utils;

import java.text.DecimalFormat;

/**
 *
 * @author naufalnibros
 */
public class FormatUtils {
    
    public static String price(int value){
        return new DecimalFormat("Rp'.' #,###").format(value);
    }
    
}
