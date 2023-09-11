package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class gestionagenda {

    String fechafin = "2023-2-12";
    Date fe = new Date();
    DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    String fechainicial = formatofecha.format(new Date());
    int diarecordar;
    String descripcion;
    LocalDate fecha = LocalDate.parse(fechainicial);

    public void fechainicio(String fechabegin) {
        int dia, mes, ano;
        String fecha1 = fechabegin;
        String[] fecha = fecha1.split("-");
        ano = Integer.parseInt(fecha[0]);
        mes = Integer.parseInt(fecha[1]);
        dia = Integer.parseInt(fecha[2]);
        System.out.println("la feha inicio es: dia " + dia + " mes " + mes + " año " + ano);
    }

    public void fechafin(String fechaend) {
        int dia, mes, ano;
        String fecha1 = fechaend;
        String[] fecha = fecha1.split("-");
        ano = Integer.parseInt(fecha[0]);
        mes = Integer.parseInt(fecha[1]);
        dia = Integer.parseInt(fecha[2]);
        System.out.println("la feha inicio es: dia " + dia + " mes " + mes + " año " + ano);
    }

    public long metodosfechas(String fechainicio, String fechafin) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        Date firstDate = sdf.parse("06/15/2023");
//        Date secondDate = sdf.parse("02/28/2030");
//        long diff = secondDate.getTime() - firstDate.getTime();
//        TimeUnit time = TimeUnit.DAYS; 
//        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
//        System.out.println("The diferencia en días es: "+diffrence);
//        
//        Date hoy = new Date();
//        System.out.println("la fecha de hoy es: "+hoy);
//        String fecha = sdf.format(hoy);
//        System.out.println("la fecha en formato es: "+fecha);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechainicio);
        Date secondDate = sdf.parse(fechafin);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: " + diffrence);

        Date hoy = new Date();
        System.out.println("la fecha de hoy es: " + hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: " + fecha);
        return diffrence;
    }
}
