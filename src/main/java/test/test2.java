package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class test2 {

    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar();
        System.out.println("calendario es: "+cal.getTime().toString());
        String calendario = cal.getTime().toString();
        System.out.println("el calendario en toString es: "+calendario);
        System.out.println("Otra prueba:\n "+cal.getFirstDayOfWeek());
        String fechafin = "2023-2-12";
        Date fe = new Date();
        Date fe1 = fe;
        Date fe2, resultado;
        System.out.println("la fecha fe es: " + fe);
        
        SimpleDateFormat fe11 = new SimpleDateFormat("yyyy-dd-MM");
        fe11.format(fe1);

        System.out.println("la fecha fe11 es: " + fe11.format(fe1));

        DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

        String fechainicial = formatofecha.format(new Date());
        fechainicio(fechainicial);
        fechafin(fechafin);
        int diarecordar;
        String descripcion;
        LocalDate fecha = LocalDate.parse(fechainicial);
        System.out.println("la fecha es: " + fecha);
        fecha = fecha.minusDays(23);
        System.out.println("la fecha con diferencia es: " + fecha);

    }

    public static void fechainicio(String fechabegin) {
        int dia, mes, ano;
        String fecha1 = fechabegin;
        String[] fecha = fecha1.split("-");
        ano = Integer.parseInt(fecha[0]);
        mes = Integer.parseInt(fecha[1]);
        dia = Integer.parseInt(fecha[2]);
        System.out.println("la feha inicio es: dia " + dia + " mes " + mes + " año " + ano);
    }

    public static void fechafin(String fechaend) {
        int dia, mes, ano;
        String fecha1 = fechaend;
        String[] fecha = fecha1.split("-");
        ano = Integer.parseInt(fecha[0]);
        mes = Integer.parseInt(fecha[1]);
        dia = Integer.parseInt(fecha[2]);
        System.out.println("la feha inicio es: dia " + dia + " mes " + mes + " año " + ano);
    }
}
