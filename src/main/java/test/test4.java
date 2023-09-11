package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import modelo.*;
import modeloDAO.*;

public class test4 {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    static long dia;
    static String descripcion;
    public static void main(String[] args) {
        System.out.println(dias.SABADO.getDIAS());
        calendariotributario cal = new calendariotributario();
        cal.setNit(1);
        System.out.println("El codigo registrado segun el nit es: "+cal.getNit());
        List<calendariotributario> lista = new calendariotributarioDAO().agendaempresascalendario1(cal);
        for(calendariotributario lis : lista){
//            System.out.println("los datos buscados son: "+lis);
            System.out.println("los datos buscados son: "+lis.getFecha()+" - "+lis.getDescripcion()+" - "+lis.getDiarecordar());
        }
        consulta con = new consulta();
        con.setNit(901038244);
        List<consulta> listaespecifica = new consultaDAO().select2(con);
        for (consulta liscon: listaespecifica){
            System.out.println("los datos de la empresa son: "+liscon.getFecha()+" y "+liscon.getDescripcion());
        }
        String fechau = lista.get(0).getFecha();
        descripcion = listaespecifica.get(0).getDescripcion();
        Date fechahoy = new Date();
        String fechadehoy;
        System.out.println("la fecha de la base de dato es: "+fechau);
        fechadehoy = sdf.format(fechahoy);
        System.out.println("la fecha de hoy al formato es: "+fechadehoy);
        try{
            dia = convertirfechas(fechadehoy , fechau);
            System.out.println("la diferencia de fecha es: "+dia);
        }catch (Exception e){
            System.out.println("la exception es: "+e);
        }
        if(dia<=0){
            System.out.println("Se ha pasado de dia por: "+dia+" para el servicio de "+descripcion);
        }else{
            System.out.println("No hay pendiente aún para ..."+descripcion);
        }
        
        
    }
    
    public static long convertirfechas(String fechaprimera, String fechaultima) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaprimera);
        Date secondDate = sdf.parse(fechaultima);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS; 
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: "+diferencia);
        Date hoy = new Date();
        System.out.println("la fecha de hoy es: "+hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: "+fecha);
        return diferencia;
    }
}
