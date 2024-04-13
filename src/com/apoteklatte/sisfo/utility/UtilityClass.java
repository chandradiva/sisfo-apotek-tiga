/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sony Vaio
 */
public class UtilityClass {

    public static boolean isInteger(String param) {
        try {
            Double.parseDouble(param);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        
        return true;
    }
    
    public static String formatDateToString(Date param) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (param != null) {
            result = sdf.format(param);
        }
        
        return result;
    }
    
    public static String formatDateTimeToString(Date param) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (param != null) {
            result = sdf.format(param);
        }
        
        return result;
    }
}
