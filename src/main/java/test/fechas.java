/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author miguelarcadioarangoluna
 */
public class fechas {
    
    public void convertirfechas() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse("06/15/2023");
        Date secondDate = sdf.parse("02/28/2030");
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: "+diffrence);
        
        Date hoy = new Date();
        System.out.println("la fecha de hoy es: "+hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: "+fecha);
        
    }
}
