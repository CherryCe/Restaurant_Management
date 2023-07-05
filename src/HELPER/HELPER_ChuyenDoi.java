/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author CherryCe
 */
public class HELPER_ChuyenDoi {

    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static String LayNgayString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    public static String LayNgayString2(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public static Date LayNgayDate(String ngay) {
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date LayNgayDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String SoString(double so) {
        return NumberFormat.getNumberInstance().format(so);
    }

    public static int SoInt(String so) {
        try {
            return NumberFormat.getNumberInstance().parse(so).intValue();
        } catch (ParseException ex) {
            return 0;
        }
    }

    public static double SoDouble(String so) {
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            return 0;
        }
    }
}
